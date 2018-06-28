package com.github.dumock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jetty on 18/6/28.
 */

@SpringBootApplication
@ComponentScan("com.github.dumock")
public class ApplicationRunner {

    public static void main(String[] args){
        SpringApplication.run(ApplicationRunner.class, args);
    }

}

