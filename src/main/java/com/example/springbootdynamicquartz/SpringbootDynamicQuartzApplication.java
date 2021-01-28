package com.example.springbootdynamicquartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootDynamicQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamicQuartzApplication.class, args);
    }

}
