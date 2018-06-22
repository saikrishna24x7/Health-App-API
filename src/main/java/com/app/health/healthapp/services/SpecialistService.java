package com.app.health.healthapp.services;

import com.app.health.healthapp.repositories.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistService {

    private SpecialistRepository specialistRepository;

    @Autowired
    public SpecialistService(SpecialistRepository specialistRepository) {
        super();
        this.specialistRepository = specialistRepository;
    }


}
