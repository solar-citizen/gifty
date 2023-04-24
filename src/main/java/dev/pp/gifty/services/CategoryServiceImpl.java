package dev.pp.gifty.services;

import dev.pp.gifty.entities.Category;
import dev.pp.gifty.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger log = LogManager.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Optional<List<Category>> getAllCategories() {
        return Optional.of(categoryRepository.findAll());
    }

    @Transactional
    public Optional<Category> getCategoryById(Long id) {
        return Optional.ofNullable(categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + id)));
    }

    @Transactional
    public Optional<Category> createCategory(Category category) {
        try {
            categoryRepository.save(category);
        } catch (DataAccessException e) {
            log.error("Failed to create a new category./n", e);
        }

        return Optional.of(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + id));
        categoryRepository.delete(category);
    }

    @Transactional
    public Optional<Category> updateCategory(Category category) {
        try {
            categoryRepository.save(category);
        } catch (DataAccessException e) {
            log.error("Failed to update a category./n", e);
        }

        return Optional.of(category);
    }

}
