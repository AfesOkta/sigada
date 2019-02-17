package com.id.sigada;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SigadaApplication {

    Logger log = LogManager.getLogger(SigadaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SigadaApplication.class, args);
    }

}
