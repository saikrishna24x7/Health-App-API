package com.app.health.healthapp.services;

import com.app.health.healthapp.models.Patient;
import com.app.health.healthapp.repositories.PatientRepository;
import com.app.health.healthapp.utils.CryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientService.class);

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        this.patientRepository.findAll().forEach(patientList::add);
        return patientList;
    }

    public Patient getPatientById(Long id) {
        Patient patient = new Patient();
        this.patientRepository.findById(id).ifPresent(p -> {
            patient.setId(p.getId());
            patient.setUsername(p.getUsername());
            patient.setEmail(p.getEmail());
        });
        return patient;
    }

    public Patient getPatientByUsername(String username) {
        Patient patient = null;
        List<Patient> patientList = new ArrayList<>();
        this.patientRepository.findPatientsByUsername(username).forEach(patientList::add);
        if (patientList.size() > 0) {
            patient = patientList.get(0);
            return patient;
        }
        return patient;
    }

    public Patient getPatientByUsernameAndPassword(String username, String password) {
        Patient patient = null;
        List<Patient> patientList = new ArrayList<>();
        this.patientRepository.findPatientByUsernameAndPassword(username, password).forEach(patientList::add);
        if (patientList.size() > 0) {
            patient = patientList.get(0);
            return patient;
        }
        return patient;
    }

    public String addPatient(Patient patient) {
        patient.setPassword(CryptUtils.encrypt(patient.getPassword()));
        this.patientRepository.save(patient);
        return "Saved";
    }

    public String signup(Patient patient) {
        patient.setPassword(CryptUtils.encrypt(patient.getPassword()));
        this.patientRepository.save(patient);
        return "Saved";
    }
}
