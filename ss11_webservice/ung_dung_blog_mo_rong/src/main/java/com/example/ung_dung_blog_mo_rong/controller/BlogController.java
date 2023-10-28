package com.example.ung_dung_blog_mo_rong.controller;


import com.example.ung_dung_blog_mo_rong.model.Blog;
import com.example.ung_dung_blog_mo_rong.service.IBlogService;
import com.example.ung_dung_blog_mo_rong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("limit/{number}")
    public ResponseEntity<?> getBlogsLimit(@PathVariable int number){
        if (blogService.getBlogLimit(number) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.blogService.getBlogLimit(number), HttpStatus.OK);
    }
//    @GetMapping()
//    public ResponseEntity<?> getBlogs() {
//        if (blogService.findAllByStatusIsFalse() == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(this.blogService.findAllByStatusIsFalse(), HttpStatus.OK);
//    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBlogDetail(@PathVariable Integer id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.blogService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlog(@RequestBody Blog blog) {
        blog.setPostingTime(LocalDateTime.now());
        this.blogService.create(blog);
    }

    @PutMapping()
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        if (blogService.findById(blog.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.update(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("search/{search}")
    public ResponseEntity<?> search(@PathVariable String search){
        List<Blog> blogList = blogService.findByNameBlogContainingAndStatusIsFalse(search);
        if (blogList.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }

}
