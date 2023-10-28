package com.example.ung_dung_blog_mo_rong.repository;

import com.example.ung_dung_blog_mo_rong.model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStratusIsFalse();

    Category getCategoryByIdCategoryAndStratusIsFalse(Integer id);
}
