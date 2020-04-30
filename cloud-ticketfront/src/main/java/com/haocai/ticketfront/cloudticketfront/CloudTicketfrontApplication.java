package com.haocai.ticketfront.cloudticketfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.haocai.feign.cloudticketfeign.feignservice","com.haocai.ticketfront.cloudticketfront"})
@EnableEurekaClient
@EnableFeignClients
public class CloudTicketfrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTicketfrontApplication.class, args);
    }

}
