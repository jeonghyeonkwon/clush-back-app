package com.clush.clushbackapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClushBackAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClushBackAppApplication.class, args);
    }

}
