package com.example.ung_dung_blog_mo_rong.service;

import com.example.ung_dung_blog_mo_rong.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void create(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> findAllByStatusIsFalse(Pageable pageable);

    Page<Blog> findByNameBlogContainingAndStatusIsFalse(String search, Pageable pageable);
}

