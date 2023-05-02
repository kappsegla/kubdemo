package com.example.kubdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class KubdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubdemoApplication.class, args);
    }

}
