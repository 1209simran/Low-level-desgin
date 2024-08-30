package dao;

import model.Patient;
import model.TimeSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientDao {

    public static PatientDao patientDao = null;
    private HashMap<String, Patient> patients;

    public PatientDao() {
        this.patients = new HashMap<>();
    }

    public static PatientDao getInstance() {
        if (patientDao == null)
            patientDao = new PatientDao();
        return patientDao;
    }

    public boolean isPatientExist(String id) {
        return patients.containsKey(id);
    }

    public void registerPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    public void freeSlot(String patientId, TimeSlot timeSlot, String docId) {
        Patient patient = patients.get(patientId);
        patient.getBookedSlots().get(docId).remove(timeSlot);
        if (patient.getBookedSlots().get(docId).size() == 0)
            patient.getBookedSlots().remove(docId);
        patients.put(patientId, patient);
    }

    public Patient getPatientDetails(String patId) {
        return patients.get(patId);
    }

    public void bookAppointment(String patId, TimeSlot timeSlot, String docId) {
        Patient patient = patients.get(patId);
        List<TimeSlot> timeSlotList = new ArrayList<>();
        if (patient.getBookedSlots().containsKey(docId))
            timeSlotList = patient.getBookedSlots().get(docId);
        timeSlotList.add(timeSlot);
        HashMap<String, List<TimeSlot>> newTs = new HashMap<>();
        newTs.put(docId, timeSlotList);
        patient.setBookedSlots(newTs);
        patients.put(patId, patient);
    }
}
