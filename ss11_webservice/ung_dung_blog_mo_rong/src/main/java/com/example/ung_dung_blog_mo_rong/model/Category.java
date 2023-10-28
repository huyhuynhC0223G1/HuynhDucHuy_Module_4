package com.example.ung_dung_blog_mo_rong.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCategory;
    private String nameCategory;
    private boolean stratus;

    public Category() {
    }

    public Category(Integer idCategory, String nameCategory, boolean stratus) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.stratus = stratus;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public boolean isStratus() {
        return stratus;
    }

    public void setStratus(boolean stratus) {
        this.stratus = stratus;
    }
}
