package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.Specialist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialistRepository extends CrudRepository<Specialist, Long> {
    List<Specialist> findSpecialistsByUsername(String username);

    List<Specialist> findSpecialistsByUsernameAndPassword(String username, String password);
}
