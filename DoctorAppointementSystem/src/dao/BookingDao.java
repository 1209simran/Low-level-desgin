package dao;

import model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDao {

    public static BookingDao bookingDao = null;
    private HashMap<String, Booking> bookings;

    public BookingDao() {
        this.bookings = new HashMap<>();
    }

    public static BookingDao getInstance() {
        if (bookingDao == null)
            bookingDao = new BookingDao();
        return bookingDao;
    }

    public Booking getBookingById(String bookingId) {
        return bookings.get(bookingId);
    }

    public boolean isBookingExist(String bookingId) {
        return bookings.containsKey(bookingId);
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public void updateBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public List<Booking> getBookingsByPatId(String patId) {
        List<Booking> bookingByPatId = new ArrayList<>();
        for (Map.Entry<String, Booking> entry : bookings.entrySet())
            if (entry.getValue().getPatientId().equalsIgnoreCase(patId))
                bookingByPatId.add(entry.getValue());
        return bookingByPatId;
    }
}
