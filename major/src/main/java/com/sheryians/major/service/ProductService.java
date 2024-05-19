package com.sheryians.major.service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductService provides methods to manage products.
 * It interacts with the ProductRepository to perform CRUD operations.
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products
     */
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
