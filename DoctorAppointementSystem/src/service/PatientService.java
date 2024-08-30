package service;

import dao.DoctorDao;
import dao.PatientDao;
import enums.Specialization;
import model.Doctor;
import model.Patient;
import model.TimeSlot;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PatientService {

    private final PatientDao patientDao;
    private final DoctorDao doctorDao;

    public PatientService(PatientDao patientDao, DoctorDao doctorDao) {
        this.patientDao = patientDao;
        this.doctorDao = doctorDao;
    }

    public void registerPatient(String id, String name) {
        if (patientDao.isPatientExist(id)) {
            System.out.println("Patient " + id + " already exists");
            return;
        }
        Patient patient = new Patient(id, name);
        patientDao.registerPatient(patient);
        System.out.println("Successfully registered patient ->" + id);
    }

    public void searchAvailableSlots(String spec) {
        Specialization specialization = Specialization.valueOf(spec);
        List<Doctor> doctors = doctorDao.getDoctorsBySpecialization(specialization);
        if (doctors == null) {
            System.out.println("No doctors found for spec ->" + spec);
            return;
        }
        Set<Doctor> availableDoctors = new HashSet<>();
        doctors.forEach(doctor -> {
            for (Map.Entry<TimeSlot, Boolean> entry : doctor.getTimeSlots().entrySet())
                if (entry.getValue())
                    availableDoctors.add(doctor);
        });
        availableDoctors.forEach(doctor -> {
            System.out.println("Doctor id -> " + doctor.getId());
            System.out.println("Doctor name -> " + doctor.getName());
            System.out.println("Doctor specialization -> " + doctor.getSpecialization());
            System.out.println("Doctor Time slots:");
            for (Map.Entry<TimeSlot, Boolean> entry : doctor.getTimeSlots().entrySet()) {
                System.out.println("start time -> " + entry.getKey().getStartTime());
                System.out.println("end time -> " + entry.getKey().getEndTime());
                System.out.println();
            }
            System.out.println();
        });
    }
    
}
