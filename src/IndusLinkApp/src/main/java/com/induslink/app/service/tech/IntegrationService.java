package com.induslink.app.service.tech;


import jakarta.annotation.PostConstruct;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Service;


@Service
public class IntegrationService {

    private CamelContext camelContext;

    @PostConstruct
    public void initialize() {
        try {
            camelContext = new DefaultCamelContext();
            camelContext.start();  // Start the Camel context
            System.out.println("Camel context started successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopCamel() {
        try {
            if (camelContext != null) {
                camelContext.stop();
                System.out.println("Camel context stopped successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
