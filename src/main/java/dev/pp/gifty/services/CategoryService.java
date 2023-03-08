package dev.pp.gifty.services;

import dev.pp.gifty.entities.Category;
import dev.pp.gifty.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private static final Logger log = LogManager.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<List<Category>> allCategories() {
        return Optional.of(categoryRepository.findAll());
    }

    public Optional<Category> category(int categoryId) {
        return Optional.ofNullable(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + categoryId)));
    }

//    public Optional<Category> createCategory(Category category) {
    public Optional<Category> createCategory(String name) {
        Category category = new Category(name);

        try {
            categoryRepository.save(category);
        } catch (Exception e) {     //---> DataAccessException ?
            log.error("Failed to create new category./n", e);
        }

        return Optional.of(category);
    }

}
