package com.haocai.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.haocai.order.mapper")
public class CloudOrderServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderServerApplication.class, args);
    }
}
