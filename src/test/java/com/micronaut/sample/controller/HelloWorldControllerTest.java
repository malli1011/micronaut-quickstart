package com.micronaut.sample.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class HelloWorldControllerTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void helloWorldEndpointRespondsWithProperContent() {
        var response = client.toBlocking().retrieve("/hello");
        assertEquals("Hello World of Micronaut!!", response);
    }


    @Test
    void helloWorldEndpointRespondsWithProperContentAndStatusCode() {
        var response = client.toBlocking().exchange("/hello", String.class);
        assertEquals("Hello World of Micronaut!!", response.body());
        assertEquals(HttpStatus.OK, response.getStatus());
    }


    @Test
    void helloWorldEndpointRespondsFromTranslationContente() {
        var response = client.toBlocking().exchange("/hello/tr/config", String.class);
        assertEquals("{\"de\":\"Hallo Welt\",\"en\":\"Hello World\",\"tm\":\"Vanakkam Ulagam\"}", response.body());

    }
}