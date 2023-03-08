package dev.pp.gifty.controllers;

import dev.pp.gifty.entities.Category;
import dev.pp.gifty.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<Optional<List<Category>>> getAllCategories() {
        return new ResponseEntity<>(categoryService.allCategories(), HttpStatus.OK);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{categoryId}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable int categoryId) {
        return new ResponseEntity<>(categoryService.category(categoryId), HttpStatus.OK);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public ResponseEntity<Optional<Category>> addCategory(@RequestBody String categoryName) {
        return new ResponseEntity<>(categoryService.createCategory(categoryName), HttpStatus.CREATED);
    }

}
