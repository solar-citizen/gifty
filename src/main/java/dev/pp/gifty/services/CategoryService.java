package dev.pp.gifty.services;

import dev.pp.gifty.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    Optional<List<Category>> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Optional<Category> createCategory(Category category);

    Optional<Category> updateCategory(Category category);

    void deleteCategory(Long id);

}
