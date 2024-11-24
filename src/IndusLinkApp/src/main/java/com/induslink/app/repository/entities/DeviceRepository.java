package com.induslink.app.repository.entities;

import com.induslink.app.models.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findByStatus(Device.Status status);

    List<Device> findByLocationName(String locationName);
}

