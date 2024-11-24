package com.example.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class Service1To2Controller {

    @Autowired private WebClient service2WebClient;

     @GetMapping("/service1to2")
    String service1to2() {
        return service2WebClient.get()
            .uri("/hello")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}



