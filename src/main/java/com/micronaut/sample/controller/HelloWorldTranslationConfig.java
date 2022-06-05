package com.micronaut.sample.controller;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldTranslationConfig {

    @NotBlank
    String getDe();
    @NotBlank
    String getEn();
    @NotBlank
    String getTm();
}
