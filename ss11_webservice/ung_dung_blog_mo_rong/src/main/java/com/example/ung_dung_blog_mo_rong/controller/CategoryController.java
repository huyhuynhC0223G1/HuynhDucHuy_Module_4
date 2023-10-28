package com.example.ung_dung_blog_mo_rong.controller;


import com.example.ung_dung_blog_mo_rong.model.Category;
import com.example.ung_dung_blog_mo_rong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<?> getCategory() {
        if (categoryService.findAll() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryDetail(@PathVariable Integer id) {
        if (categoryService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category) {
        this.categoryService.create(category);
    }

    @PutMapping()
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        if (categoryService.findById(category.getIdCategory()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.categoryService.update(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        if (categoryService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

