package com.profinch.fincluez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FinCluezWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinCluezWebAppApplication.class, args);
    }

}
