package model;

public class Booking {

    private String bookingId;
    private String doctorId;
    private String patientId;
    private boolean isCancelled;
    private boolean isWaiting;
    private TimeSlot timeSlot;

    public Booking(String bookingId, String doctorId, String patientId, TimeSlot timeSlot) {
        this.bookingId = bookingId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.timeSlot = timeSlot;
        this.isCancelled = false;
        this.isWaiting = false;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }
}
