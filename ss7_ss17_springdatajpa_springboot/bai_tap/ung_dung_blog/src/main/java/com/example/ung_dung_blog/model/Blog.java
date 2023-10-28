package com.example.ung_dung_blog.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nameBlog")
    private String nameBlog;
    @Column(name = "contentBlog", columnDefinition = "text")
    private String contentBlog;
    @Column(name = "postingTime")
    private LocalDateTime postingTime;

    public Blog() {
    }

    public Blog(Integer id, String nameBlog, String contentBlog, LocalDateTime postingTime) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.postingTime = postingTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public LocalDateTime getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(LocalDateTime postingTime) {
        this.postingTime = postingTime;
    }
}
