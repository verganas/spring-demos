package config;

import hotpackage.Patient;
import hotpackage.PatientImpl;

import org.springframework.context.annotation.Bean;

public class HealthCareConfig {
	
	@Bean
	Patient patient() {
		return new PatientImpl();
	}
}
