package com.example.ung_dung_blog_mo_rong.service;

import com.example.ung_dung_blog_mo_rong.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<Category> findAll();

    void create(Category category);

    Category findById(Integer id);

    void update(Category category);

    void remove(Integer id);
}

