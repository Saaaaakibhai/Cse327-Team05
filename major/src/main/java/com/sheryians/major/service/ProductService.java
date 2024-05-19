package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products
     */
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    /**
     * Adds a new product to the database.
     *
     * @param product The Product object to be added.
     */
    public void addProduct (Product product) {
        productRepository.save(product);
    }
    /**
     * Removes a product from the database based on its ID.
     *
     * @param id The ID of the product to be removed.
     */
    public void removeProductById(long id){
        productRepository.deleteById(id);
    }
    /**
     * Finds a product from the database based on its ID.
     *
     * @param id The ID of the product to be searched.
     * @return An Optional object containing the Product if found, or empty if not found.
     */
    public Optional<Product> getProductById (long id){
        return productRepository.findById(id);
    }
    /**
     * Retrieves all products belonging to a specific category based on the category ID.
     *
     * @param id The ID of the category to filter products by.
     * @return A list containing all Product objects belonging to the specified category.
     */
    public List<Product> getAllProductsbyCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
}
