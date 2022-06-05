package com.micronaut.sample.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/hello")
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);
    private final HelloWorldTranslationConfig translationConfig;

    public HelloWorldController(HelloWorldTranslationConfig translationConfig) {
        this.translationConfig = translationConfig;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        LOGGER.debug("Hello World!");
        return "Hello World of Micronaut!!";
    }

    @Get(value = "/tr/config", produces = MediaType.APPLICATION_JSON)
    public HelloWorldTranslationConfig helloWorldWithTranslation() {
        LOGGER.debug("Hello World!");
        return translationConfig;
    }
}
