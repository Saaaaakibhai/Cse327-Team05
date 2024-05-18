package com.sheryians.major.repository;

import com.sheryians.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository is a repository interface for performing CRUD operations on Product entities.
 * It extends JpaRepository to provide methods for interacting with the database.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
