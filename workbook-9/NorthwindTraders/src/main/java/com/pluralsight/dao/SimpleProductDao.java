package com.pluralsight.dao;

import com.pluralsight.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private ArrayList<Product> products;
    private int counter = 4;

    public SimpleProductDao(){
        this.products = new ArrayList<>();

        this.products.add(0, new Product(1,"Shrimp","Seafood",12.99));
        this.products.add(1, new Product(2,"Cake Mix","Baking",1.99));
        this.products.add(2, new Product(3,"Lettuce","Fresh",2.99));
        this.products.add(3, new Product(4,"Sprinkles","Baking",1.99));
    };


    @Override
    public int persistProduct(Product product) {
        int id = counter++;
        products.add(new Product(id, product.getName(),product.getCategory(),product.getPrice()));
        return id;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.get(id-1);
    }

}
