package com.example.tsl.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/errors/access-error")
    public String accessDenied() {
        return "errors/access-error";
    }
}
