package com.sheryians.major.service;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * CategoryService provides methods to manage categories.
 * It interacts with the CategoryRepository to perform CRUD operations.
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    /**
     * Retrieves all categories from the repository.
     *
     * @return a list of all categories
     */
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    /**
     * Adds a new category to the repository.
     *
     * @param category the category to be added
     */
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    /**
     * Removes a category from the repository by its ID.
     *
     * @param id the ID of the category to be removed
     */
    public void removeCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to be retrieved
     * @return an Optional containing the found category, or an empty Optional if not found
     */
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
}
