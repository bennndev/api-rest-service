package com.lab10.api_rest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestServiceApplication.class, args);
    }

}