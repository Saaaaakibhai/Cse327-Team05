package com.sheryians.major.controller;

import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sheryians.major.controller.HomeController;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HomeControllerTest {
    private MockMvc mockMvc;
    CategoryService categoryService;

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController(); // Manually create controller instance

        // No service interaction needed for home page
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testShopPage() throws Exception {
        // Mock services
        CategoryService mockCategoryService = mock(CategoryService.class);
        ProductService mockProductService = mock(ProductService.class);

        // Mock data (assuming some categories and products exist)
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        HomeController controller = new HomeController();

        // Mock service interactions
        Mockito.when(mockCategoryService.getAllCategory()).thenReturn(categories);
        Mockito.when(mockProductService.getAllProduct()).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/shop"))
                .andExpect(status().isOk())
                .andExpect(view().name("shop"))
                .andExpect(model().attribute("categories", categories))
                .andExpect(model().attribute("products", products));
    }

    @Test
    public void testShopByCategory() throws Exception {
        HomeController controller = new HomeController();
        int categoryId = 1;

        // Mock data (assuming products exist for the category)
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        // Mock service interaction
        Mockito.when(controller.productService.getAllProductsbyCategoryId(categoryId)).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/shop/category/{id}", categoryId))
                .andExpect(status().isOk())
                .andExpect(view().name("shop"))
                .andExpect(model().attribute("products", products));
    }

    @Test
    public void testViewProduct() throws Exception {
        HomeController controller = new HomeController();
        int productId = 1;

        // Mock data (assuming a product exists with the given ID)
        Product product = new Product();

        // Mock service interaction
        Mockito.when(controller.productService.getProductById(productId)).thenReturn(Optional.of(product));

        mockMvc.perform(MockMvcRequestBuilders.get("/shop/viewproduct/{id}", productId))
                .andExpect(status().isOk())
                .andExpect(view().name("viewProduct"))
                .andExpect(model().attribute("product", product));
    }

    @Test
    public void testViewProductNotFound() throws Exception {
        HomeController controller = new HomeController();
        int productId = 1;

        // Mock data (assuming product not found by ID)
        Mockito.when(controller.productService.getProductById(productId)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/shop/viewproduct/{id}", productId))
                // Expect a redirect to a potentially defined error page or default behavior
                .andExpect(status().isFound());
    }
}
