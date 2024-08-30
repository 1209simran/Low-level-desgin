package dao;

import enums.Specialization;
import model.Doctor;
import model.TimeSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorDao {

    public static DoctorDao doctorDao = null;
    private HashMap<String, Doctor> doctors;
    private HashMap<Specialization, List<String>> doctorsIdBySpecialization;

    public DoctorDao() {
        this.doctors = new HashMap<>();
        this.doctorsIdBySpecialization = new HashMap<>();
    }

    public static DoctorDao getInstance() {
        if (doctorDao == null)
            doctorDao = new DoctorDao();
        return doctorDao;
    }

    public boolean isDoctorExist(String id) {
        return doctors.containsKey(id);
    }

    public void registerDoctor(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
        List<String> doctorList = new ArrayList<>();
        if (doctorsIdBySpecialization.containsKey(doctor.getSpecialization()))
            doctorList = doctorsIdBySpecialization.get(doctor.getSpecialization());
        doctorList.add(doctor.getId());
        doctorsIdBySpecialization.put(doctor.getSpecialization(), doctorList);
    }

    public boolean isTimeExist(String docId, String startTime) {
        Doctor doctor = doctors.get(docId);
        for (HashMap.Entry<TimeSlot, Boolean> entry : doctor.getTimeSlots().entrySet()) {
            if (entry.getKey().getStartTime().equalsIgnoreCase(startTime))
                return true;
        }
        return false;
    }

    public void addTimeSlot(String docId, TimeSlot timeSlot) {
        Doctor doctor = doctors.get(docId);
        HashMap<TimeSlot, Boolean> timeSlotHashMap = doctor.getTimeSlots();
        timeSlotHashMap.put(timeSlot, true);
        doctor.setTimeSlots(timeSlotHashMap);
        doctors.put(docId, doctor);
    }


    public List<Doctor> getDoctorsBySpecialization(Specialization specialization) {
        if (!doctorsIdBySpecialization.containsKey(specialization))
            return null;
        List<String> doctorIds = doctorsIdBySpecialization.get(specialization);
        List<Doctor> doctorList = new ArrayList<>();
        doctorIds.forEach(id -> {
            doctorList.add(doctors.get(id));
        });
        return doctorList;
    }

    public void freeSlot(String docId, TimeSlot timeSlot) {
        Doctor doctor = doctors.get(docId);
        for (Map.Entry<TimeSlot, Boolean> entry : doctor.getTimeSlots().entrySet()) {
            if (entry.getKey().getStartTime().equalsIgnoreCase(timeSlot.getStartTime())) {
                entry.setValue(true);
            }
        }
        doctors.put(docId, doctor);
    }

    public boolean isDoctorAvailable(String docId, String startTime) {
        Doctor doctor = doctors.get(docId);
        for (Map.Entry<TimeSlot, Boolean> entry : doctor.getTimeSlots().entrySet()) {
            if (entry.getKey().getStartTime().equalsIgnoreCase(startTime) && entry.getValue())
                return true;
        }
        return false;
    }

    public void bookAppointment(String docId, String startTime) {
        Doctor doctor = doctors.get(docId);
        for (Map.Entry<TimeSlot, Boolean> entry : doctor.getTimeSlots().entrySet()) {
            if (entry.getKey().getStartTime().equalsIgnoreCase(startTime)) {
                entry.setValue(false);
            }
        }
        doctors.put(docId, doctor);
    }
}
