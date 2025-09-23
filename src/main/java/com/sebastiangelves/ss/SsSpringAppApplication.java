package com.sebastiangelves.ss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotación habilita la autoconfiguración de Spring Boot
@SpringBootApplication
public class SsSpringAppApplication {

    // El método main que inicia la aplicación
    public static void main(String[] args) {
        SpringApplication.run(SsSpringAppApplication.class, args);
    }

}