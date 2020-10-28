package com.learnseata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LearnSeataEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSeataEurekaApplication.class, args);
    }

}
