package com.example.vet_clinic_management_backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class VetClinicManagementBackendApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		// Connect to Firebase database
		ClassLoader classloader = VetClinicManagementBackendApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classloader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		// Check if FirebaseApp is already initialized before initializing again
		if (FirebaseApp.getApps().isEmpty()) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
            FirebaseApp.initializeApp(options);
        }
		
		// Start Springboot application
		SpringApplication.run(VetClinicManagementBackendApplication.class, args);
	}

}

// http://localhost:8080/swagger-ui/index.html