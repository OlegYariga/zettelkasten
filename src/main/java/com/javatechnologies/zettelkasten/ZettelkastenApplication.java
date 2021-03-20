package com.javatechnologies.zettelkasten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ZettelkastenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZettelkastenApplication.class, args);
    }
}
