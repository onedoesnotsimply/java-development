package com.pluralsight.dao;

import com.pluralsight.model.Product;

import java.util.List;

public interface ProductDao {
    public int persistProduct(Product product);
    public Product getById(int id);
    public List<Product> getAll();
}
