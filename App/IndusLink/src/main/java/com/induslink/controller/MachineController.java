package com.induslink.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    // Endpoint to check if the service is working
    @GetMapping("/status")
    public String checkStatus() {
        return "IndusLink API is running!";
    }
}
