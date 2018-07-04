package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findPatientsByUsername(String username);

    List<Patient> findPatientByUsernameAndPassword(String username, String password);

    boolean existsPatientByUsername(String username);
}