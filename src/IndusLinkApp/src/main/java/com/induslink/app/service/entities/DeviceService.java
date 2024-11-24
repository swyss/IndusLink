package com.induslink.app.service.entities;

import com.induslink.app.models.entities.Device;
import com.induslink.app.repository.entities.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(Long id) {
        return Optional.ofNullable(deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Device with ID " + id + " not found")));
    }

    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        if (!deviceRepository.existsById(id)) {
            throw new EntityNotFoundException("Device with ID " + id + " not found");
        }
        deviceRepository.deleteById(id);
    }
}

