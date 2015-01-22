package com.demo.web.controllers;
 
import com.demo.core.domain.DomainBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class SampleController {

    @Autowired
    private DomainBean domainBean;
 
    @RequestMapping("/")
    public String loadHomePage(Model m) {
        m.addAttribute("name", domainBean.getName());
        return "home";
    }
}