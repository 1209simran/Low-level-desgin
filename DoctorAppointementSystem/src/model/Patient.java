package model;

import java.util.HashMap;
import java.util.List;

public class Patient {

    private String id;
    private String name;
    private HashMap<String, List<TimeSlot>> bookedSlots;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.bookedSlots = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, List<TimeSlot>> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(HashMap<String, List<TimeSlot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }
}
