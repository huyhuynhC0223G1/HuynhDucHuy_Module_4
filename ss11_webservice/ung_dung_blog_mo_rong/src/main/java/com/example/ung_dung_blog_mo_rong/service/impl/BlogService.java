package com.example.ung_dung_blog_mo_rong.service.impl;


import com.example.ung_dung_blog_mo_rong.model.Blog;
import com.example.ung_dung_blog_mo_rong.repository.IBlogRepository;
import com.example.ung_dung_blog_mo_rong.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public String update(Blog blog) {
        blogRepository.save(blog);
        return null;
    }

    @Override
    public void remove(Integer id) {
        Blog blog = blogRepository.getBlogByIdAndStatusIsFalse(id);
        blog.setStatus(true);
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAllByStatusIsFalse() {
        return blogRepository.findAllByStatusIsFalse();
    }

    @Override
    public List<Blog> findByNameBlogContainingAndStatusIsFalse(String search) {
        return blogRepository.findByNameBlogContainingAndStatusIsFalse(search);
    }

    @Override
    public List<Blog> getBlogLimit(int number) {
        return blogRepository.getBlogLimit(number);
    }


}
