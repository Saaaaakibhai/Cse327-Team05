package com.sheryians.major.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sheryians.major.dto.ProductDTO;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;


import java.util.Optional;


/**
 * The AdminController class handles all admin-related HTTP requests.
 * It provides endpoints for managing categories and products.
 */
@Controller
public class AdminController {

    /**
     * The upload directory for the product image.
     */
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";


    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    /**
     * Handles the GET request for the admin home page.
     *
     * @return the name of the admin home view
     */
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    /**
     * Handles the GET request for the categories page.
     * Adds the list of all categories to the model.
     *
     * @param model the model to which the categories are added
     * @return the name of the categories view
     */
    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    /**
     * Handles the GET request for the add category page.
     * Adds a new Category object to the model.
     *
     * @param model the model to which the new category is added
     * @return the name of the add category view
     */
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    /**
     * Handles the POST request to add a new category.
     *
     * @param category the category to be added
     * @return a redirect to the categories page
     */
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    /**
     * Handles the GET request to delete a category by its ID.
     *
     * @param id the ID of the category to be deleted
     * @return a redirect to the categories page
     */
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    /**
     * Handles the GET request to update a category by its ID.
     * Adds the category to the model if found, otherwise returns an error view.
     *
     * @param id the ID of the category to be updated
     * @param model the model to which the category is added
     * @return the name of the update category view or an error view if the category is not found
     */
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "484";
        }
    }

    /**
     * Handles the GET request for the products page.
     * Adds the list of all products to the model.
     *
     * @param model the model to which the products are added
     * @return the name of the products view
     */
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    /**
     * Handles the GET request for the add product page.
     * Adds a new ProductDTO object and the list of all categories to the model.
     *
     * @param model the model to which the new product and categories are added
     * @return the name of the add product view
     */
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }
    /**
     * Handles the product addition form submission from the admin panel.
     * The method converts a productDTO object into a product object
     * and then adds it to the product database.
     * @param productDTO A ProductDTO object containing the submitted product details.
     * @param file The uploaded product image file (MultipartFile).
     * @param imgName A fallback image name if no file is uploaded.
     * @return A string redirecting to the admin product list page ("redirect:/admin/products").
     * @throws IOException If there's an error while writing the uploaded image file.
     */
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException{
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());

        } else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);


        return "redirect:/admin/products";
    }
    /**
     * Handles the product deletion request from the admin panel.
     *
     * @param id The ID of the product to be deleted (PathVariable).
     * @return A string redirecting to the admin product list page ("redirect:/admin/products").
     */
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    /**
     * Handles the product deletion request from the admin panel.
     *
     * @param id The ID of the product to be deleted (PathVariable).
     * @return A string redirecting to the admin product list page ("redirect:/admin/products").
     */
    @GetMapping("/admin/product/update/{id}")
    public String updateProductGet(@PathVariable long id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);
        return "productsAdd";
    }
}
