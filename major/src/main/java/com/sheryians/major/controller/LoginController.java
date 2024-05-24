package com.sheryians.major.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "loginPage"; // Change the returned view name to avoid circular path
    }

    @GetMapping("/register")
    public String registerGet() {
        return "registerPage"; // Change the returned view name to avoid circular path
    }
}