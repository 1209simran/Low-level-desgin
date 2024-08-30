package service;

import dao.DoctorDao;
import enums.Specialization;
import model.Doctor;
import model.TimeSlot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DoctorService {
    private final DoctorDao doctorDao;

    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public void registerDoctor(String id, String name, String specialization) {
        if (doctorDao.isDoctorExist(id)) {
            System.out.println("Doctor " + id + " already exists");
            return;
        }
        Specialization spec = Specialization.valueOf(specialization);
        Doctor doctor = new Doctor(id, name, spec);
        doctorDao.registerDoctor(doctor);
        System.out.println("Successfully registered doctor ->" + id);
    }

    public void addSlots(String docId, String startTime, String endTime) {
        if (!doctorDao.isDoctorExist(docId)) {
            System.out.println("Doctor " + docId + " doesn't exist!");
            return;
        }
        if (!isValidTimeSlot(startTime, endTime)) {
            System.out.println("Time slot should be of 30 mins only");
            return;
        }
        if (doctorDao.isTimeExist(docId, startTime)) {
            System.out.println("Time slot already exist for docId ->" + docId);
            return;
        }
        TimeSlot timeSlot = new TimeSlot(startTime, endTime);
        doctorDao.addTimeSlot(docId, timeSlot);
        System.out.println("Added time slot startTime->" + startTime + ", endTime-> " + endTime + " for docId -> " + docId);
    }

    private boolean isValidTimeSlot(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startDate = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endTime, formatter);
        long minutesBetween = ChronoUnit.MINUTES.between(startDate, endDate);
        if (minutesBetween > 30)
            return false;
        return true;
    }
}
