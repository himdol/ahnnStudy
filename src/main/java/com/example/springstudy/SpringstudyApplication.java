package com.example.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringstudyApplication.class, args);
    }

}
