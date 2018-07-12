package com.app.health.healthapp.services;

import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.models.Patient;
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

    public HealthApiResponse addPatientReport(PatientReport patientReport) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        this.patientReportRepository.save(patientReport);
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        return healthApiResponse;
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

    public HealthApiResponse getReportsByDoctor(PatientReport patientReport) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<PatientReport> patientReportList = new ArrayList<>();
        this.patientReportRepository.findAllByDoctorName(patientReport.getDoctorName()).forEach(patientReportList::add);
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        healthApiResponse.setPatientReports(patientReportList);
        return healthApiResponse;
    }

    public HealthApiResponse getReportsBySpecialist(PatientReport patientReport) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<PatientReport> patientReportList = new ArrayList<>();
        this.patientReportRepository.findAllBySpecialistName(patientReport.getSpecialistName()).forEach(patientReportList::add);
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        healthApiResponse.setPatientReports(patientReportList);
        return healthApiResponse;
    }

    public HealthApiResponse updateSpecialist(PatientReport patientReport) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        this.patientReportRepository.updateSpecialist(patientReport.getSpecialistName(), patientReport.getPatientID());
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        return healthApiResponse;
    }
}
