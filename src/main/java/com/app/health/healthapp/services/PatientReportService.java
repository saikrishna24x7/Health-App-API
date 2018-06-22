package com.app.health.healthapp.services;

import com.app.health.healthapp.models.PatientReport;
import com.app.health.healthapp.repositories.PatientReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientReportService {
    private PatientReportRepository patientReportRepository;

    @Autowired
    public PatientReportService(PatientReportRepository patientReportRepository) {
        super();
        this.patientReportRepository = patientReportRepository;
    }

    public String addPatientReport(PatientReport patientReport) {
        this.patientReportRepository.save(patientReport);
        return "Saved";
    }

    public List<PatientReport> getAllPatientReports() {
        List<PatientReport> patientReportList = new ArrayList<>();
        this.patientReportRepository.findAll().forEach(patientReportList::add);
        return patientReportList;
    }

    public List<PatientReport> getAllPatientReportsByPatient(String patientId) {
        List<PatientReport> patientReportList = new ArrayList<>();
        this.patientReportRepository.findAllByPatientID(patientId).forEach(patientReportList::add);
        return patientReportList;
    }
}
