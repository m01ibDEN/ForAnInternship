package com.m01libDEN.ForAnInternship;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String output(@RequestParam(value = "string", defaultValue = "") String string) {
        return new Algorithm(string).util();
    }
}
