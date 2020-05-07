package com.haocai.ticketserver.cloudticketserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.haocai.ticketserver.cloudticketserver.mapper")
public class CloudTicketserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTicketserverApplication.class, args);
    }

}
