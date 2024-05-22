package com.sheryians.major.controller;

import org.hibernate.type.TrueFalseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    /*
    S. M. Mahedi Hasan {Feature}
     */
    @Test
    void login() {
        LoginController loginController = new LoginController(True);
        String result = loginController.login(True);
        Assertions.assertEquals("True",result);
    }
}