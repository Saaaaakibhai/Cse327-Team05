package com.sheryians.major.controller;

import com.sheryians.major.model.Category;
import com.sheryians.major.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private CategoryService categoryService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    void testUpdateCat_CategoryExists() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("Electronics");

        when(categoryService.getCategoryById(anyInt())).thenReturn(Optional.of(category));

        mockMvc.perform(get("/admin/categories/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesAdd"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", category));
    }

    @Test
    void testUpdateCat_CategoryDoesNotExist() throws Exception {
        when(categoryService.getCategoryById(anyInt())).thenReturn(Optional.empty());

        mockMvc.perform(get("/admin/categories/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("484"));
    }



}

