# springboot-vet-clinic-management-backend
`Created by Jin Xuan`  
`Last updated by Jin Xuan on 14/1/2025`

## Overview

The **Vet Clinic Management Services** is a backend application built using Spring Boot. It provides APIs to manage a veterinary clinic's operations, including managing booking appointments, client or pet owners, pets, lab diagnostics report and medical inventory.

## Modules
**Appointment Scheduling**: Create, update, and manage appointments.

**Client Management**: Add, update, view, and delete client records.

**Pet Management**: Track information about pets, their breeds, and medical histories.

**Lab Diagnostics**: Create, update and manage lab diagnostics results.

**Medical Inventory**: Create, update, delete and manage and track medical supplies and equipment. 

## Tech Stack
**Backend Framework**: Spring Boot

**Database**: Firebase Firestore

**Build Tool**: Maven

**Programming Language**: Java 17

## Base URL
The service is available at http://localhost:8080

## API Endpoints
For a detailed list of available API endpoints and to test them, please refer to the Swagger UI after running the service: 
```
http://localhost:8080/swagger-ui/index.html
```
## Build

The build uses Apache Maven. Simply use:

```
mvn clean install
```

## Run
1) Clone the repository:
```
git clone <repository-url>
cd vet-clinic-management
```
2) Configure Firebase:
- Download the serviceAccountKey.json file from your Firebase console.
- Place it in the src/main/resources directory.
- Update application.properties with your Firebase project details.

3) Install dependencies:
```
mvn clean install
```

4) Run the application:
```
mvn spring-boot:run
```
5) The application will start at http://localhost:8080.

6) To access the Swagger UI, open your browser and navigate to the following URL:
```
http://localhost:8080/swagger-ui/index.html
```