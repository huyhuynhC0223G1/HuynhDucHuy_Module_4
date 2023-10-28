package com.example.quan_li_san_pham.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "product_name", nullable = false, unique = true)
    private String name;
    @Column(name = "describer")
    private String describe;
    @Column(name = "producer")
    private String producer;
    @Column(name = "price")
    private double price;

    public Product() {
    }

    public Product(int id, String name, String describe, String producer, double price) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.producer = producer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
