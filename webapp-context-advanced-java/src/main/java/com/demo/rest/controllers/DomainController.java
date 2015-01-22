package com.demo.rest.controllers;

import com.demo.core.domain.DomainBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainController {

    @Autowired
    DomainBean domainBean;

    @RequestMapping(value = "/domain",method = RequestMethod.GET)
    DomainBean domainBean() {
        return domainBean;
    }

}
