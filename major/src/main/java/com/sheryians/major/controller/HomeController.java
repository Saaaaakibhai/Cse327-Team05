package com.sheryians.major.controller;

import com.sheryians.major.global.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
/**
 * Handles the displaying of products in the frontend.
 */
@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    /**
     * Maps requests to "/" or "/home" URLs.
     *
     * @param model A Model object used to store data for the view template.
     * @return A string referencing the "index" view template.
     */
    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }
    /**
     * Maps requests to the "/shop" URL.
     *
     * @param model A Model object used to store data for the view template.
     * @return A string referencing the "shop" view template.
     */
    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }
    /**
     * Maps requests to the "/shop/category/{id}" URL to display products by category.
     *
     * @param model A Model object used to store data for the view template.
     * @param id The ID of the category to filter products by (PathVariable).
     * @return A string referencing the "shop" view template, displaying the products by category.
     */
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductsbyCategoryId(id));
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }
    /**
     * Maps requests to the "/shop/viewproduct/{id}" URL to display a single product's details.
     *
     * @param model A Model object used to store data for the view template.
     * @param id The ID of the product to be displayed (PathVariable).
     * @return A string referencing the "viewProduct" view template, containing product details.
     */
    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "viewProduct";
    }

}
