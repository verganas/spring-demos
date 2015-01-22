package com.demo.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DomainBean {
    private static Logger logger = LoggerFactory.getLogger(DomainBean.class);

    private String name;

    public DomainBean(){
        logger.info("DomainBean Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
