package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDao {
    public void persistProduct(Product product);
    public List<Product> getAll();
    public void deleteProduct(Product product);
}
