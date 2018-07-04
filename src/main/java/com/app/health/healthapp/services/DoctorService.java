package com.app.health.healthapp.services;

import com.app.health.healthapp.models.Doctor;
import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.models.Patient;
import com.app.health.healthapp.repositories.DoctorRepository;
import com.app.health.healthapp.utils.CryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        super();
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        this.doctorRepository.findAll().forEach(doctorList::add);
        return doctorList;
    }

    public Doctor getDoctorById(Long id) {
        Doctor doctor = new Doctor();
        this.doctorRepository.findById(id).ifPresent(d -> {
            doctor.setUsername(d.getUsername());
            doctor.setId(d.getId());
            doctor.setEmail(d.getEmail());
        });
        return doctor;
    }

    public Doctor getDoctorByUsername(String username) {
        Doctor doctor = null;
        List<Doctor> doctorList = new ArrayList<>();
        this.doctorRepository.findDoctorsByUsername(username).forEach(doctorList::add);
        if (doctorList.size() > 0) {
            doctor = doctorList.get(0);
        }
        return doctor;
    }

    public Doctor getDoctorByUsernameAndPassword(String username, String password) {
        Doctor doctor = null;
        List<Doctor> doctorList = new ArrayList<>();
        this.doctorRepository.findDoctorsByUsernameAndPassword(username, password).forEach(doctorList::add);
        if (doctorList.size() > 0) {
            doctor = doctorList.get(0);
        }
        return doctor;
    }

    public HealthApiResponse addDoctor(Doctor doctor) {
        this.doctorRepository.save(doctor);
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        return healthApiResponse;
    }

//    public HealthApiResponse addDoctorWithCheck(Doctor doctor){
//        HealthApiResponse healthApiResponse = new HealthApiResponse();
//        boolean status = this.doctorRepository.existsDoctorByUsername(doctor.getUsername());
//        if(status){
//            healthApiResponse.setResponseStatus(false);
//            healthApiResponse.setResponseMessage("User Already Exists");
//        }else{
//            this.doctorRepository.save(doctor);
//            healthApiResponse.setResponseStatus(true);
//            healthApiResponse.setResponseMessage("Success");
//        }
//        return healthApiResponse;
//    }

    public HealthApiResponse signup(Doctor doctor) {
        doctor.setPassword(CryptUtils.encrypt(doctor.getPassword()));
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        boolean status = this.doctorRepository.existsDoctorByUsername(doctor.getUsername());
        if (status) {
            healthApiResponse.setResponseStatus(false);
            healthApiResponse.setResponseMessage("User Already Exists");
        } else {
            this.doctorRepository.save(doctor);
            healthApiResponse.setResponseStatus(true);
            healthApiResponse.setResponseMessage("Success");
        }
        return healthApiResponse;
    }

    public HealthApiResponse login(Doctor doctor) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<Doctor> doctorList = new ArrayList<>();
        this.doctorRepository.findDoctorsByUsernameAndPassword(doctor.getUsername(), CryptUtils.encrypt(doctor.getPassword()))
                .forEach(doctorList::add);
        if (doctorList.size() == 1) {
            healthApiResponse.setResponseStatus(true);
            healthApiResponse.setResponseMessage("Success");
            healthApiResponse.setUsername(doctorList.get(0).getUsername());
        } else {
            healthApiResponse.setResponseStatus(false);
            healthApiResponse.setResponseMessage("Login Failed");
        }
        return healthApiResponse;
    }
}