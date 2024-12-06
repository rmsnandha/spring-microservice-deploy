package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@Slf4j
public class Service1To2Controller {

    @Autowired private WebClient service2WebClient;

     @GetMapping("/service1to2")
    String service1to2() {
         log.info("Calling service 2 from service 1");
        return service2WebClient.get()
            .uri("/hello")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}



