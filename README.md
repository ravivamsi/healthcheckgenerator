# Health Check Generator

A Spring Boot application that provides health check endpoints for multiple components with various JSON payloads and 200 OK responses.

## Components Supported

- **GIS** - Geographic Information System
- **POC** - Proof of Concept
- **RMD** - Risk Management Dashboard
- **OPTION** - Options Trading System
- **FUTURE** - Futures Trading System
- **LEG** - Leg Trading System
- **Index** - Index Management System
- **Target** - Target Management System

## Features

- RESTful API endpoints for each component
- JSON responses with detailed health information
- 200 OK status codes for all healthy components
- Timestamp and version information
- System metrics (CPU, memory usage)
- Component-specific metrics and status
- Aggregate health check endpoint

## API Endpoints

### Individual Component Health Checks

- `GET /api/health/gis` - GIS component health check
- `GET /api/health/poc` - POC component health check
- `GET /api/health/rmd` - RMD component health check
- `GET /api/health/option` - OPTION component health check
- `GET /api/health/future` - FUTURE component health check
- `GET /api/health/leg` - LEG component health check
- `GET /api/health/index` - Index component health check
- `GET /api/health/target` - Target component health check

### Aggregate Health Check

- `GET /api/health/all` - Health check for all components

## Response Format

All endpoints return JSON responses with the following structure:

```json
{
  "status": "healthy",
  "component": "COMPONENT_NAME",
  "timestamp": "2024-01-15 10:30:45",
  "version": "x.x.x",
  "uptime": "X days, Y hours, Z minutes",
  "memory_usage": "XX%",
  "cpu_usage": "XX%",
  "component_specific_metrics": {...}
}
```

## Running the Application

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Build and Run

1. Clone the repository:
```bash
git clone <repository-url>
cd healthcheckgenerator
```

2. Build the application:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

Or run the JAR file:
```bash
java -jar target/healthcheck-generator-1.0.0.jar
```

### Access the Application

The application will be available at:
- Base URL: `http://localhost:8080`
- Health Check Endpoints: `http://localhost:8080/api/health/{component}`

## Example Usage

### Check GIS Health
```bash
curl http://localhost:8080/api/health/gis
```

### Check All Components
```bash
curl http://localhost:8080/api/health/all
```

## Sample Response

```json
{
  "status": "healthy",
  "component": "GIS",
  "timestamp": "2024-01-15 10:30:45",
  "version": "2.1.0",
  "uptime": "15 days, 8 hours, 32 minutes",
  "memory_usage": "45%",
  "cpu_usage": "12%",
  "active_connections": 156,
  "last_backup": "2024-01-15 02:30:00",
  "services": {
    "database": "connected",
    "cache": "operational",
    "external_api": "responsive"
  }
}
```

## Configuration

The application can be configured through `application.properties`:

- Server port: `server.port=8080`
- Logging level: `logging.level.com.healthcheck=INFO`
- Actuator endpoints: `management.endpoints.web.exposure.include=health,info,metrics`

## Development

### Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── healthcheck/
│   │           ├── HealthCheckGeneratorApplication.java
│   │           └── controller/
│   │               └── HealthCheckController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── healthcheck/
```

### Adding New Components

To add a new component health check:

1. Add a new endpoint method in `HealthCheckController.java`
2. Follow the existing pattern with appropriate metrics
3. Ensure the response includes `"status": "healthy"`
4. Return `ResponseEntity.ok(response)`

## License

This project is licensed under the MIT License - see the LICENSE file for details.
