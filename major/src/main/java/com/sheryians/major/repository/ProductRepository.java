package com.sheryians.major.repository;

import com.sheryians.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository <Product, Long> {
    /**
     * Retrieves all products belonging to a specific category based on the category ID.
     *
     * @param id The ID of the category to filter products by.
     * @return A list containing all Product objects belonging to the specified category.
     */
    List<Product> findAllByCategory_Id(int id);
}

