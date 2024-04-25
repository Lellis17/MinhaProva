package com.example.RestIbge.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.RestIbge.repository")
public class RestIbgeapplication {
    public static void main(String[] args) {
        SpringApplication.run(RestIbgeapplication.class, args);
    }
}