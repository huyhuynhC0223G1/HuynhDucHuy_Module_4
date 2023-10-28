package com.example.ung_dung_blog_mo_rong.repository;


import com.example.ung_dung_blog_mo_rong.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByStatusIsFalse();
    Blog getBlogByIdAndStatusIsFalse(Integer id);
    List<Blog> findByNameBlogContainingAndStatusIsFalse(String search);
    @Query(nativeQuery = true, value = "select * from blog where status = 'false' limit :number")
    List<Blog> getBlogLimit(int number);
}
