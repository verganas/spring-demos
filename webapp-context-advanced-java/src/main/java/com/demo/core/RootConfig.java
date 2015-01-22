package com.demo.core;


import com.demo.core.domain.DomainBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class RootConfig {

    @Bean
    DomainBean domainBean() {
        DomainBean bean = new DomainBean();
        bean.setName("Explicitly initialized");
        return bean;
    }

}
