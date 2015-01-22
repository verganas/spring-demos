package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import otherpackage.Student;
import otherpackage.StudentImpl;

@Configuration
@Import(value= {HealthCareConfig.class,BeanHolderConfig.class})
public class EducationConfig {

	@Bean
	Student student() {
		return new StudentImpl();
	}
}
