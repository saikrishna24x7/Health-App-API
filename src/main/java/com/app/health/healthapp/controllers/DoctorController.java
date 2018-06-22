package com.app.health.healthapp.controllers;

import com.app.health.healthapp.models.Doctor;
import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        super();
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HealthApiResponse addDoctor(@RequestBody Doctor doctor) {
        return this.doctorService.addDoctor(doctor);
    }

    @RequestMapping(value = "/getall")
    public List<Doctor> getAllDoctors() {
        return this.doctorService.getAllDoctors();
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public Doctor getDoctorById(@RequestBody Doctor doctor) {
        return this.doctorService.getDoctorById(doctor.getId());
    }

    @RequestMapping(value = "getbyusername", method = RequestMethod.POST)
    public Doctor getDoctorByUsername(@RequestBody Doctor doctor) {
        return this.doctorService.getDoctorByUsername(doctor.getUsername());
    }

    @RequestMapping(value = "getbyusernamepassword", method = RequestMethod.POST)
    public Doctor getDoctorByUsernameAndPassword(@RequestBody Doctor doctor) {
        return this.doctorService.getDoctorByUsernameAndPassword(doctor.getUsername(), doctor.getPassword());
    }

//    @RequestMapping(value = "/check", method = RequestMethod.POST)
//    public HealthApiResponse checkIfDoctorExists(@RequestBody Doctor doctor){
//        return this.doctorService.addDoctorWithCheck(doctor);
//    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public HealthApiResponse signup(@RequestBody Doctor doctor) {
        return this.doctorService.signup(doctor);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HealthApiResponse login(@RequestBody Doctor doctor) {
        return this.doctorService.login(doctor);
    }
}