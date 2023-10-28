package com.example.quan_li_san_pham.repository;

import com.example.quan_li_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> findSearch(String search);
}
