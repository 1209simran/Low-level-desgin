package service;

import dao.BookingDao;
import dao.DoctorDao;
import dao.PatientDao;
import model.Booking;
import model.Patient;
import model.TimeSlot;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookingService {

    private final BookingDao bookingDao;
    private final PatientDao patientDao;
    private final DoctorDao doctorDao;
    private Queue<Booking> waitListQueue;

    public BookingService(BookingDao bookingDao, PatientDao patientDao, DoctorDao doctorDao) {
        this.bookingDao = bookingDao;
        this.patientDao = patientDao;
        this.doctorDao = doctorDao;
        this.waitListQueue = new LinkedList<>();
    }

    public Booking bookAppointment(String patId, String docId, String dateAndTime) {
        if (!patientDao.isPatientExist(patId)) {
            System.out.println("Patient " + patId + " doesn't exist");
            return null;
        }
        if (!doctorDao.isDoctorExist(docId)) {
            System.out.println("Doctor " + docId + " doesn't exist!");
            return null;
        }
        Patient patient = patientDao.getPatientDetails(patId);
        TimeSlot timeSlot = new TimeSlot(dateAndTime, dateAndTime);
        boolean isAlreadyBoooked = checkIfSlotAlreadyBooked(patient, docId, dateAndTime);
        if (isAlreadyBoooked) {
            System.out.println("Already appointment is booked for: " + dateAndTime + " wth doctor id:" + docId);
            return null;
        }
        Booking booking = new Booking(UUID.randomUUID().toString(), docId, patId, timeSlot);
        if (!doctorDao.isDoctorAvailable(docId, dateAndTime)) {
            System.out.println("No doctors available at " + dateAndTime + ". Adding to waitlist");
            booking.setWaiting(true);
            waitListQueue.add(booking);
            return booking;
        }
        doctorDao.bookAppointment(docId, dateAndTime);
        patientDao.bookAppointment(patId, timeSlot, docId);
        bookingDao.addBooking(booking);
        System.out.println("Booked an appointment of " + patId + " with docId -> " + docId);
        return booking;
    }


    private boolean checkIfSlotAlreadyBooked(Patient patient, String docId, String dateAndTime) {
        AtomicBoolean isAlreadBoooked = new AtomicBoolean(false);
        List<TimeSlot> bookedSlots = patient.getBookedSlots().get(docId);
        if (bookedSlots != null) {
            bookedSlots.forEach(timeSlot -> {
                if (timeSlot.getStartTime().equalsIgnoreCase(dateAndTime)) {
                    isAlreadBoooked.set(true);
                }
            });
        }
        return isAlreadBoooked.get();
    }

    public void cancelAppointment(String bookingId) {
        if (!bookingDao.isBookingExist(bookingId)) {
            System.out.println("Booking " + bookingId + " doesn't exist");
            return;
        }
        Booking booking = bookingDao.getBookingById(bookingId);
        booking.setCancelled(true);
        doctorDao.freeSlot(booking.getDoctorId(), booking.getTimeSlot());
        patientDao.freeSlot(booking.getPatientId(), booking.getTimeSlot(), booking.getDoctorId());
        System.out.println("Cancelled the booking -> " + bookingId);
        checkForWaitList();
    }

    private void checkForWaitList() {
        Booking booking = null;
        while (!waitListQueue.isEmpty()) {
            booking = waitListQueue.poll();
            if (!booking.isCancelled())
                break;
        }
        if (booking != null) {
            booking.setWaiting(false);
            bookingDao.updateBooking(booking);
            doctorDao.bookAppointment(booking.getDoctorId(), booking.getTimeSlot().getStartTime());
            patientDao.bookAppointment(booking.getPatientId(), booking.getTimeSlot(), booking.getDoctorId());
            bookingDao.addBooking(booking);
            System.out.println("Booked an appointment of " + booking.getPatientId() + " with docId -> " + booking.getDoctorId());
        }
    }

    public void viewBookedAppointments(String patId) {
        if (!patientDao.isPatientExist(patId)) {
            System.out.println("Patient " + patId + " doesn't exist");
            return;
        }
        List<Booking> bookingsList = bookingDao.getBookingsByPatId(patId);
        for (Booking booking : bookingsList) {
            if (!booking.isCancelled())
                System.out.println("Booking id " + booking.getBookingId() + ", " + booking.getDoctorId() +
                        " at " + booking.getTimeSlot().getStartTime());
        }
    }
}
