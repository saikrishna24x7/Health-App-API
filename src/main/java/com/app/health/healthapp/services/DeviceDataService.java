package com.app.health.healthapp.services;

import com.app.health.healthapp.models.DeviceData;
import com.app.health.healthapp.repositories.DeviceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceDataService {

    private DeviceDataRepository deviceDataRepository;

    @Autowired
    public DeviceDataService(DeviceDataRepository deviceDataRepository) {
        super();
        this.deviceDataRepository = deviceDataRepository;
    }

    public String addDeviceData(DeviceData deviceData) {
        this.deviceDataRepository.save(deviceData);
        return "Saved";
    }

    public List<DeviceData> getAllDeviceData() {
        List<DeviceData> deviceDataList = new ArrayList<>();
        this.deviceDataRepository.findAll().forEach(deviceDataList::add);
        return deviceDataList;
    }
}
