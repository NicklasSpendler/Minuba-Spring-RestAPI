package com.hovedopgave.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class HelloworldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Helloworld greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Helloworld(counter.incrementAndGet(), String.format(template, name));
    }

}
