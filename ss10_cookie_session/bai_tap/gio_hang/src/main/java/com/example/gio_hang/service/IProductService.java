package com.example.gio_hang.service;

import com.example.gio_hang.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);
}
