import dao.BookingDao;
import dao.DoctorDao;
import dao.PatientDao;
import model.Booking;
import service.BookingService;
import service.DoctorService;
import service.PatientService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DoctorDao doctorDao = DoctorDao.getInstance();
        PatientDao patientDao = PatientDao.getInstance();
        BookingDao bookingDao = BookingDao.getInstance();

        DoctorService doctorService = new DoctorService(doctorDao);
        PatientService patientService = new PatientService(patientDao, doctorDao);
        BookingService bookingService = new BookingService(bookingDao, patientDao, doctorDao);

        doctorService.registerDoctor("doc1", "Doctor1", "CARDIOLOGIST");
        doctorService.registerDoctor("doc2", "Doctor2", "CARDIOLOGIST");
        doctorService.registerDoctor("doc3", "Doctor3", "DERMATOLOGIST");

        patientService.registerPatient("pat1", "Patient1");
        patientService.registerPatient("pat2", "Patient2");
        patientService.registerPatient("pat3", "Patient3");

        doctorService.addSlots("doc1", "2024-08-20 09:30:00", "2024-08-20 10:00:00");
        doctorService.addSlots("doc1", "2024-08-20 09:30:00", "2024-08-20 10:00:00");
        doctorService.addSlots("doc1", "2024-08-20 10:30:00", "2024-08-20 11:00:00");
        doctorService.addSlots("doc2", "2024-08-20 09:30:00", "2024-08-20 10:00:00");
        doctorService.addSlots("doc2", "2024-08-20 10:30:00", "2024-08-20 11:00:00");
        doctorService.addSlots("doc2", "2024-08-20 10:30:00", "2024-08-20 11:30:00");

        patientService.searchAvailableSlots("CARDIOLOGIST");

        Booking booking1 = bookingService.bookAppointment("pat1", "doc1", "2024-08-20 09:30:00");
        Booking booking2 = bookingService.bookAppointment("pat2", "doc1", "2024-08-20 09:30:00");

        bookingService.cancelAppointment(booking1.getBookingId());

        bookingService.viewBookedAppointments("pat1");
        bookingService.viewBookedAppointments("pat2");


    }
}