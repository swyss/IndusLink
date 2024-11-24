### IndusLink: Real-Time Monitoring and Management Application

---

## **Description**

IndusLink is a real-time monitoring and management application for industrial machines. It connects to devices using the OPC UA protocol, collects operational data, and organizes it through semantic technologies for advanced analysis and visualization. The primary objectives are to improve machine efficiency, enable predictive maintenance, and provide a user-friendly dashboard for desktop environments.

---

## **Key Functional Requirements**

### 1. OPC UA Integration
- **Device Connectivity**: Support all OPC UA server types and devices. Use Eclipse Milo for real-time data access.
- **Dynamic Device Discovery**: Automatically detect new devices on the network for seamless integration.
- **Parallel Connections**: Manage multiple concurrent OPC UA connections, including load balancing.
- **Data Points**: Collect machine-specific metrics (e.g., operational status, temperature, energy consumption) with adjustable intervals.
- **Test OPC UA Server**: Include a Docker-based OPC UA server for testing, independent of the application.

### 2. Semantic Modeling with Ontologies
- **Data Contextualization**: Integrate industrial standards such as SSN and RDF using Apache Jena and OWL API for ontology management.
- **Flexible Model**: Support different machine types and configurations with a customizable ontology model.
- **SPARQL Interface**: Provide powerful query capabilities for decision-making.

### 3. Real-Time Monitoring and Dashboard
- **UI Design**: Develop an intuitive dashboard using Vaadin to display real-time data, status indicators, and historical trends.
- **Visualizations**: Offer graphs (line, bar, timeline) and optionally heat maps.
- **Alerts and Notifications**: Configurable thresholds with pop-up notifications for critical events.
- **Customizable Widgets**: Allow users to personalize widgets and dashboard layouts.

### 4. Predictive Maintenance and Analytics
- **Data Analysis**: Identify patterns in real-time and historical data to predict maintenance needs.
- **Maintenance KPIs**: Provide metrics like OEE (Overall Equipment Effectiveness), MTBF (Mean Time Between Failures), and MT2R (Mean Time to Repair).
- **Machine Learning**: Incorporate basic machine learning models for predictive maintenance.

### 5. User Roles and Security
- **Role-Based Access**: Implement user roles (e.g., "User", "Admin") with specific permissions.
- **Authentication and Authorization**: Local authentication with potential LDAP integration.

---

## **Technical Requirements**

### Platform
- **Java-Based Web Application**: Spring Boot for a lightweight, embedded server solution.

### Frontend
- **Vaadin Flow**: A reactive Java-based UI framework.

### Backend Components
- **OPC UA**: Eclipse Milo for device connectivity and data retrieval.
- **Semantic Technologies**: Apache Jena and OWL API for data modeling and ontology management.
- **Databases**: PostgreSQL for relational data, InfluxDB for time-series data.
- **Event Streaming**: Apache Kafka for real-time data processing.
- **Apache Camel**: Orchestrate and integrate data flows, including routing and transformation between components like OPC UA and Kafka.

### Server
- **Embedded Server**: Spring Boot with embedded Tomcat.

### Build and Dependency Management
- **Maven**: Manage dependencies and project builds.

### Testing
- **JUnit 5**: Unit and integration testing.
- **Vaadin Testbench**: Optional end-to-end UI testing.
- **Docker Test Environment**: Include the test OPC UA server and other services in a Docker environment.

---

## **Extended Requirements**

### Data Storage
- **Archiving**: Store historical data in PostgreSQL/InfluxDB with retention policies.
- **Data Cleanup**: Provide automated data management and cleanup features via the dashboard.

### Offline Mode
- **Network Independence**: Operate without a network connection, with data synchronization upon reconnection.

### Extensibility
- **External APIs**: Offer APIs for external system integration.
- **Modular Design**: Support additional device types and data sources through modular architecture.

### Security
- **Data Validation**: Ensure data integrity and secure sensitive information.
- **Encryption**: Optional encryption for data communication.

### Scalability
- **Flexible Architecture**: Design the application to scale for multiple users and larger datasets.

---

## **Project Architecture**

### Frontend (UI Layer)
- **Vaadin Flow**: Interactive visualization and controls.
- **Main View**: Display machine statuses, alerts, and visualizations.

### Backend (Business Logic Layer)
- **OPC UA Integration**: Manage device connectivity and data processing.
- **Ontology Service**: Model data relationships and provide SPARQL query capabilities.
- **Event Streaming**: Enable scalable data processing with Apache Kafka.
- **Apache Camel Components**: Orchestrate and manage data flows.

### Persistence Layer
- **PostgreSQL**: Relational database for historical and user-specific data.
- **InfluxDB**: Time-series database for machine data analysis.

### OPC UA Layer
- **Independent Connection Management**: Handle multiple OPC UA connections.

---

## **Additional Considerations**

### Data Pipeline Monitoring
- **Dashboard for Kafka and Camel**: Monitor message flows and processing.

### Error Handling
- **Detailed Exception Management**: Implement robust error-handling mechanisms.

### Version Control
- **Git-Based CI/CD**: Ensure streamlined versioning and release management.

---
