package com.sheryians.major.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {
    /*
    S. M. Mahedi Hasan {Feature}
     */
    @Test
    void getCat() {
        AdminController adminController = new AdminController();
        String result = adminController.getCat(True);
        Assertions.assertEquals("True",result);

    }
    /*
    S. M. Mahedi Hasan {Feature}
     */
    @Test
    void getCatAdd() {
        AdminController adminController = new AdminController();
        String result = adminController.getCatAdd(True);
        Assertions.assertEquals("True",result);
    }

    @Test
    void postCatAdd() {

    }
}