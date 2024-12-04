package com.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//we need to use application name of the service as a FeignClient name which we want to call here
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
/*
  after connecting to naming server we just need to pass microservice application name which
  we want to connect it will automatically take url from eureka and also do load balancing
*/
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from, @PathVariable String to);

}
