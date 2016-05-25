package edu.sjsu.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot Application main class.
 *
 * @author Krishna Bhanushali
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan({"edu.sjsu.dao","edu.sjsu.dao.impl","edu.sjsu.controller","edu.sjsu.service","edu.sjsu.service.impl","edu.sjsu.util","edu.sjsu.main","edu.sjsu.entity"})

public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
