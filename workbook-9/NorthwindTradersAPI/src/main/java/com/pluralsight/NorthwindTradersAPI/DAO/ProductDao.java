package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Model.Product;

import java.util.List;

public interface ProductDao {
    public void persistProduct(Product product);
    public List<Product> getAll();
    public void deleteProduct(int id);
    public void updateProduct(int id, Product product);
    public Product getProductById(int id);
}