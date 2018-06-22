package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findDoctorsByUsername(String username);

    List<Doctor> findDoctorsByUsernameAndPassword(String username, String password);

    boolean existsDoctorByUsername(String username);
}