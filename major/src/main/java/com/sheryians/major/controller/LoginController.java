package com.sheryians.major.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    /*
     * User Login Register Issue
     */
    @GetMapping("/login")
    public String login() {
        return "login"; // Change the returned view name to avoid circular path
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register"; // Change the returned view name to avoid circular path
    }
}