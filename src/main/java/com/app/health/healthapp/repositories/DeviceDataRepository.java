package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.DeviceData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceDataRepository extends CrudRepository<DeviceData, Long> {
    List<DeviceData> getDeviceDataByPatientId(String patientId);
}
