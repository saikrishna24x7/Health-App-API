package com.app.health.healthapp.controllers;

import com.app.health.healthapp.models.Specialist;
import com.app.health.healthapp.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specialist")
public class SpecialistController {

    private SpecialistService specialistService;

    @Autowired
    public SpecialistController(SpecialistService specialistService) {
        super();
        this.specialistService = specialistService;
    }
}
