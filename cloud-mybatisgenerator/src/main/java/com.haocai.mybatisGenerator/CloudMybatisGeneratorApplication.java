package com.haocai.mybatisGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudMybatisGeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudMybatisGeneratorApplication.class, args);
    }

}
