package com.app.health.healthapp.controllers;

import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.models.Patient;
import com.app.health.healthapp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        super();
        this.patientService = patientService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/hellopost", method = RequestMethod.POST)
    public String helloPost(@RequestBody Patient patient) {
        return patient.getUsername();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPatient(@RequestBody Patient patient) {
        return this.patientService.addPatient(patient);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Patient getPatient(@RequestBody Patient patient) {
        return this.patientService.getPatientById(patient.getId());
    }

    @RequestMapping(value = "/getbyusername", method = RequestMethod.POST)
    public Patient getPatientByUsername(@RequestBody Patient patient) {
        return this.patientService.getPatientByUsername(patient.getUsername());
    }

    @RequestMapping(value = "/getbyusernamepassword", method = RequestMethod.POST)
    public Patient getPatientByUsernameAndPassword(@RequestBody Patient patient) {
        return this.patientService.getPatientByUsernameAndPassword(patient.getUsername(), patient.getPassword());
    }

    @RequestMapping(value = "/getall")
    public List<Patient> getAllPatients() {
        return this.patientService.getAllPatients();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HealthApiResponse login(@RequestBody Patient patient) {
        return this.patientService.login(patient);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public HealthApiResponse signUp(@RequestBody Patient patient) {
        return this.patientService.signup(patient);
    }
}