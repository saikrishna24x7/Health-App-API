package com.app.health.healthapp.services;

import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.models.Specialist;
import com.app.health.healthapp.repositories.SpecialistRepository;
import com.app.health.healthapp.utils.CryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialistService {

    private SpecialistRepository specialistRepository;

    @Autowired
    public SpecialistService(SpecialistRepository specialistRepository) {
        super();
        this.specialistRepository = specialistRepository;
    }

    public HealthApiResponse login(Specialist specialist) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<Specialist> specialistList = new ArrayList<>();
        this.specialistRepository.findSpecialistsByUsernameAndPassword(specialist.getUsername(), CryptUtils.encrypt(specialist.getPassword()))
                .forEach(specialistList::add);
        if (specialistList.size() == 1) {
            healthApiResponse.setResponseStatus(true);
            healthApiResponse.setResponseMessage("Success");
            healthApiResponse.setUsername(specialistList.get(0).getUsername());
        } else {
            healthApiResponse.setResponseStatus(false);
            healthApiResponse.setResponseMessage("Login Failed");
        }
        return healthApiResponse;
    }

    public HealthApiResponse signup(Specialist specialist) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        boolean status = this.specialistRepository.existsSpecialistByUsername(specialist.getUsername());
        if (status) {
            healthApiResponse.setResponseStatus(false);
            healthApiResponse.setResponseMessage("User Already Exists");
        } else {
            specialist.setPassword(CryptUtils.encrypt(specialist.getPassword()));
            this.specialistRepository.save(specialist);
            healthApiResponse.setResponseStatus(true);
            healthApiResponse.setResponseMessage("Success");
        }
        return healthApiResponse;
    }

}
