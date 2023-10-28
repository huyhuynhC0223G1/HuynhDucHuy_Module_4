package com.example.ung_dung_blog_mo_rong.service;

import com.example.ung_dung_blog_mo_rong.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    void create(Blog blog);

    Blog findById(Integer id);

    String update(Blog blog);

    void remove(Integer id);

    List<Blog> findAllByStatusIsFalse();
    List<Blog> findByNameBlogContainingAndStatusIsFalse(String search);
    List<Blog> getBlogLimit(int number);
}

