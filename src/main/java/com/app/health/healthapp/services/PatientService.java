package com.app.health.healthapp.services;

import com.app.health.healthapp.models.HealthApiResponse;
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

    public HealthApiResponse signup(Patient patient) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        boolean status = this.patientRepository.existsPatientByUsername(patient.getUsername());
        if (status) {
            healthApiResponse.setResponseStatus(false);
            healthApiResponse.setResponseMessage("User Already Exists");
        } else {
            patient.setPassword(CryptUtils.encrypt(patient.getPassword()));
            this.patientRepository.save(patient);
            healthApiResponse.setResponseStatus(true);
            healthApiResponse.setResponseMessage("Success");
        }
        return healthApiResponse;
    }

    public HealthApiResponse login(Patient patient) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<Patient> patientsList = new ArrayList<>();
        this.patientRepository.findPatientByUsernameAndPassword(patient.getUsername(), CryptUtils.encrypt(patient.getPassword()))
                .forEach(patientsList::add);
        if (patientsList.size() == 1) {
            healthApiResponse.setResponseStatus(true);
            healthApiResponse.setResponseMessage("Success");
            healthApiResponse.setUsername(patientsList.get(0).getPatientId());
            healthApiResponse.setDoctorName(patientsList.get(0).getDoctor());
        } else {
            healthApiResponse.setResponseStatus(false);
            healthApiResponse.setResponseMessage("Login Failed");
        }
        return healthApiResponse;
    }
}
