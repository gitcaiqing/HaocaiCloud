package com.haocai.ticketserver.cloudticketserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({
        "com.haocai.ticketserver.cloudticketserver.mapper",
        "com.haocai.base.cloudbase.mapper"
})
@ImportResource({"classpath:applicationContext.xml"})
@EnableScheduling
@EnableTransactionManagement
public class CloudTicketserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTicketserverApplication.class, args);
    }

}
