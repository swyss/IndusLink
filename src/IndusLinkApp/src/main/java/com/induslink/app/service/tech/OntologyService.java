package com.induslink.app.service.tech;


import jakarta.annotation.PostConstruct;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.query.*;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

@Service
public class OntologyService {

    private CamelContext camelContext;
    private ProducerTemplate producerTemplate;

    @PostConstruct
    public void initialize() throws Exception {
        camelContext = new DefaultCamelContext();
        producerTemplate = camelContext.createProducerTemplate();

        // Define a Camel route to execute SPARQL queries
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:executeSparql")
                        .routeId("sparqlRoute")
                        .process(exchange -> {
                            String sparqlQuery = exchange.getIn().getBody(String.class);
                            executeSparqlQuery(sparqlQuery);
                        })
                        .to("log:sparqlResults");
            }
        });

        camelContext.start();
    }

    public void executeSparqlQuery(String sparqlQueryString) {
        // Example SPARQL query execution with Jena
        Query query = QueryFactory.create(sparqlQueryString);
        try (QueryExecution qexec = QueryExecutionFactory.create(query)) {
            ResultSet results = (ResultSet) qexec.execSelect();
            while (((org.apache.jena.query.ResultSet) results).hasNext()) {
                QuerySolution solution = ((org.apache.jena.query.ResultSet) results).nextSolution();
                System.out.println(solution);
            }
        }
    }

    public void stop() throws Exception {
        if (camelContext != null) {
            camelContext.stop();
        }
    }
}
