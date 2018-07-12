package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.PatientReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientReportRepository extends CrudRepository<PatientReport, Long> {
    List<PatientReport> findAllByPatientID(String patientId);

    List<PatientReport> findAllByDoctorName(String doctorName);

    List<PatientReport> findAllBySpecialistName(String specialistName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE patientreport p SET p.specialist_name = :specialistName WHERE p.patient_id = :patientId", nativeQuery = true)
    int updateSpecialist(@Param("specialistName") String specialistName, @Param("patientId") String patientId);
}
