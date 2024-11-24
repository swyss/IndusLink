package com.induslink.app.controller;

import com.induslink.app.service.entities.DeviceService;
import com.induslink.app.service.entities.InterfaceService;
import com.induslink.app.service.entities.LocationService;
import com.induslink.app.service.entities.MachineService;
import jakarta.activation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    private MachineService machineService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private InterfaceService interfaceService;

    /**
     * Retrieves application statistics, info, and status.
     *
     * @return a Map with application information, statistics, and status
     */
    @GetMapping
    public Map<String, Object> getAppInfo() {
        Map<String, Object> info = new HashMap<>();

        // Application Info
        Map<String, String> appInfo = new HashMap<>();
        appInfo.put("applicationName", "IndusLink");
        appInfo.put("version", "1.0.0");
        appInfo.put("description", "Real-time monitoring and management application for industrial machines.");

        // Application Status
        String appStatus = "Running"; // This could be dynamically set based on actual health checks.

        // Endpoint Statistics
        Map<String, Long> statistics = new HashMap<>();
        statistics.put("totalMachines", (long) machineService.getAllMachines().size());
        statistics.put("totalDevices", (long) deviceService.getAllDevices().size());
        statistics.put("totalLocations", (long) locationService.getAllLocations().size());
        statistics.put("totalInterfaces", (long) interfaceService.getAllInterfaces().size());

        // Combine all data into the main info map
        info.put("applicationInfo", appInfo);
        info.put("applicationStatus", appStatus);
        info.put("statistics", statistics);

        return info;
    }
    @GetMapping("/health")
    public ResponseEntity<String> getHealthStatus() {
        // Dynamically check health status, e.g., DB, services
        boolean isHealthy = true; // Replace with actual checks
        return isHealthy
                ? ResponseEntity.ok("Application is running smoothly")
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Application issues detected");
    }
}
