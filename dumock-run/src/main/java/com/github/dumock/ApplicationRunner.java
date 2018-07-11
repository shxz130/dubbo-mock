package com.github.dumock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jetty on 18/6/28.
 */

@SpringBootApplication
@ComponentScan("com.github.dumock")
@EnableWebMvc
public class ApplicationRunner {

    public static void main(String[] args){
        SpringApplication.run(ApplicationRunner.class, args);
    }

}

