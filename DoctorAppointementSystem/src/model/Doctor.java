package model;

import enums.Specialization;

import java.util.HashMap;

public class Doctor {

    private String id;
    private String name;
    private HashMap<TimeSlot, Boolean> timeSlots;
    private Specialization specialization;

    public Doctor(String id, String name, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.timeSlots = new HashMap<>();
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

    public HashMap<TimeSlot, Boolean> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(HashMap<TimeSlot, Boolean> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
