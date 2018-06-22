package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.DeviceData;
import org.springframework.data.repository.CrudRepository;

public interface DeviceDataRepository extends CrudRepository<DeviceData, Long> {
}
