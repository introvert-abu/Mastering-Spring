package com.e_com.e_commerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_com.e_commerce.model.Category;
import com.e_com.e_commerce.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/public/categories")
    public List<Category> getAllCategories() {
        return this.service.getAllCategories();
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        if (this.service.addCategory(category)) {
            return new ResponseEntity<>("Category Added Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid Parameters", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        if (this.service.updateCategory(id, category)) {
            return new ResponseEntity<>("Category Updated Succesfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Something Went Wrong!!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        if (this.service.deleteCategory(id)) {
            return new ResponseEntity<>("Category Deleted Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
    }
}
