package com.example.tsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login-form")
    public String login() {
        return "login-form";
    }

    @GetMapping("/main-page")
    public String mainPageForm() {
        return "main-page";
    }
}
