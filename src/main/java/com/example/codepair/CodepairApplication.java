package com.example.codepair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CodepairApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodepairApplication.class, args);
    }

}
