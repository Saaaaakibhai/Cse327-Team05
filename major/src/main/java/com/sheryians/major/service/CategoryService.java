package com.sheryians.major.service;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
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
