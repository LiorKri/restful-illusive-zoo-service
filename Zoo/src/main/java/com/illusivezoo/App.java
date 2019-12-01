package com.illusivezoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
public class App {

    static final Logger LOGGER=LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("Illusive Zoo Rest App Starting..");
        SpringApplication.run(App.class, args);
    }
}
