package com.app.health.healthapp.controllers;

import com.app.health.healthapp.models.DeviceData;
import com.app.health.healthapp.services.DeviceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/devicedata")
public class DeviceDataController {
    private DeviceDataService deviceDataService;

    @Autowired
    public DeviceDataController(DeviceDataService deviceDataService) {
        super();
        this.deviceDataService = deviceDataService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDeviceData(@RequestBody DeviceData deviceData) {
        return this.deviceDataService.addDeviceData(deviceData);
    }

    @RequestMapping(value = "/getall")
    public List<DeviceData> getAddDeviceData() {
        return this.deviceDataService.getAllDeviceData();
    }
}
