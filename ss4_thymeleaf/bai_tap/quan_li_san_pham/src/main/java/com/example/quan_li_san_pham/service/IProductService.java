package com.example.quan_li_san_pham.service;

import com.example.quan_li_san_pham.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    int checkProductId(int id);

    List<Product> findSearch(String search);
}
