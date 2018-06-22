package com.app.health.healthapp.controllers;

import com.app.health.healthapp.models.PatientReport;
import com.app.health.healthapp.services.PatientReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patientreport")
public class PatientReportController {

    private PatientReportService patientReportService;

    @Autowired
    public PatientReportController(PatientReportService patientReportService) {
        super();
        this.patientReportService = patientReportService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPatientReport(@RequestBody PatientReport patientReport) {
        return this.patientReportService.addPatientReport(patientReport);
    }

    @RequestMapping(value = "/getall")
    public List<PatientReport> getAllPatientReports() {
        return this.getAllPatientReports();
    }

    @RequestMapping(value = "/getbypatientid", method = RequestMethod.POST)
    public List<PatientReport> getAllPatientReportsByPatientId(@RequestBody PatientReport patientReport) {
        return this.patientReportService.getAllPatientReportsByPatient(patientReport.getPatientID());
    }
}