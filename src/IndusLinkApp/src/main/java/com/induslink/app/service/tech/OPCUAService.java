package com.induslink.app.service.tech;

import jakarta.annotation.PostConstruct;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Service;


@Service
public class OPCUAService {

    private CamelContext camelContext;
    private ProducerTemplate producerTemplate;

    @PostConstruct
    public void initialize() throws Exception {
        camelContext = new DefaultCamelContext();
        producerTemplate = camelContext.createProducerTemplate();

        // Set up Camel routes
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("milo-client:opc.tcp://localhost:4840?node=ns=2;i=2")
                        .routeId("opcuaRoute")
                        .log("Received value from OPC UA: ${body}")
                        .to("direct:processOpcData");
            }
        });

        camelContext.start();
    }

    public void stop() throws Exception {
        if (camelContext != null) {
            camelContext.stop();
        }
    }

    // Process data from the OPC UA endpoint
    public void processOpcData() {
        // Implement processing logic
    }
}

