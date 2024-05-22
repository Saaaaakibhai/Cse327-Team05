package com.sheryians.major;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MajorApplication is the entry point of the Spring Boot application.
 * It contains the main method which starts the application.
 */
@SpringBootApplication
public class MajorApplication {

    /**
     * The main method which serves as the entry point for the Spring Boot application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SpringApplication.run(MajorApplication.class, args);
    }
}
