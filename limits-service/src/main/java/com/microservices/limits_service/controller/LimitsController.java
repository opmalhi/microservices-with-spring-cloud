package com.microservices.limits_service.controller;

import com.microservices.limits_service.bean.Limits;
import com.microservices.limits_service.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        // hard coded
//        return new Limits(1, 1000);
        //getting value from application.properties through configuration class
        return new Limits(configuration.getMinimum(),
                            configuration.getMaximum());
    }

}
