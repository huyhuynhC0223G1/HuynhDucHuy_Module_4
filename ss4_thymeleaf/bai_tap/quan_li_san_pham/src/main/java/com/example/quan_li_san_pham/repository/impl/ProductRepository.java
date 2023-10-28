package com.example.quan_li_san_pham.repository.impl;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.repository.IProductRepository;
import com.example.quan_li_san_pham.service.IProductService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "bút bi", "học tâp", "thien long", 5000));
        productList.add(new Product(2, "bút mực", "học tâp", "thien long", 8000));
        productList.add(new Product(3, "bút chì", "học tâp", "thien long", 3000));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(checkProductId(id));
    }

    @Override
    public void update(int id, Product product) {
        productList.set(checkProductId(id), product);
    }

    @Override
    public void remove(int id) {
        productList.remove(checkProductId(id));
    }

    @Override
    public int checkProductId(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Product> findSearch(String search) {
        if (search == null) {
            search = "";
        }
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(search)) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }

}
