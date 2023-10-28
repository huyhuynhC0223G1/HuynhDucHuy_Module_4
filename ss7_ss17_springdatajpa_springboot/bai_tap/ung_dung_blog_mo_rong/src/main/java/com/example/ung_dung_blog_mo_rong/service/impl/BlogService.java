package com.example.ung_dung_blog_mo_rong.service.impl;


import com.example.ung_dung_blog_mo_rong.model.Blog;
import com.example.ung_dung_blog_mo_rong.repository.IBlogRepository;
import com.example.ung_dung_blog_mo_rong.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        Blog blog = blogRepository.getBlogByIdAndStatusIsFalse(id);
        blog.setStatus(true);
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByStatusIsFalse(Pageable pageable) {
        return blogRepository.findAllByStatusIsFalse(pageable);
    }

    @Override
    public Page<Blog> findByNameBlogContainingAndStatusIsFalse(String search, Pageable pageable) {
        return blogRepository.findByNameBlogContainingAndStatusIsFalse(search, pageable);
    }

}
