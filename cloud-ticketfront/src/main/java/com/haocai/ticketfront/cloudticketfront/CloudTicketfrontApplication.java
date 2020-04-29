package com.haocai.ticketfront.cloudticketfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudTicketfrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTicketfrontApplication.class, args);
    }

}
