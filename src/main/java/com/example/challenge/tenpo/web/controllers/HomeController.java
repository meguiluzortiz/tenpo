package com.example.challenge.tenpo.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HomeController {

    @GetMapping
    public String insecured() {
        return "Hello world!";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/secured")
    public String secured() {
        return "Hello secured world!";
    }
}
