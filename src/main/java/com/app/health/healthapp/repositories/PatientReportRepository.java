package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.PatientReport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientReportRepository extends CrudRepository<PatientReport, Long> {
    List<PatientReport> findAllByPatientID(String patientId);

    List<PatientReport> findAllByDoctorName(String doctorName);
}
