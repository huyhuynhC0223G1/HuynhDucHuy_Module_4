package com.example.ung_dung_blog_mo_rong.service.impl;

import com.example.ung_dung_blog_mo_rong.model.Category;
import com.example.ung_dung_blog_mo_rong.repository.ICategoryRepository;
import com.example.ung_dung_blog_mo_rong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAllByStratusIsFalse();
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        Category category = categoryRepository.getCategoryByIdCategoryAndStratusIsFalse(id);
        category.setStratus(true);
        categoryRepository.save(category);
    }
}
