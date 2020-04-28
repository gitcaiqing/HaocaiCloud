package com.haocai.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaserverApplication.class, args);
    }

}
