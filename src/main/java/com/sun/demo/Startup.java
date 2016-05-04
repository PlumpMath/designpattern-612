package com.sun.demo;

/**
 * Created by kimi on 5/3/16.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Startup {
    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }
}
