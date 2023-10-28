package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Integer id);
}

