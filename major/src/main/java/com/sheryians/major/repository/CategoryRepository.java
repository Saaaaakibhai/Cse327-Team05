package com.sheryians.major.repository;

import com.sheryians.major.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CategoryRepository is a repository interface for performing CRUD operations on Category entities.
 * It extends JpaRepository to provide methods for interacting with the database.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
