package config;

import hotpackage.Patient;

import org.springframework.context.annotation.Bean;

import otherpackage.Student;
import aggregator.BeanHolder;
import aggregator.BeanHolderImpl;
import aggregator.BeanHolderV2;
import aggregator.BeanHolderV2Impl;

public class BeanHolderConfig {

	@Bean
	BeanHolder beanHolder(Student student, Patient patient) {
		return new BeanHolderImpl(student, patient);
	}
	
	@Bean
	BeanHolderV2 beanHolderV2() {
		return new BeanHolderV2Impl();
	}
}
