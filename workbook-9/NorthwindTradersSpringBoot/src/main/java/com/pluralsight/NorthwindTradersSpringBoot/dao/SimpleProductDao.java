package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class SimpleProductDao implements ProductDao {
    private ArrayList<Product> products;
    private int counter = 5;

    //@Autowired
    public SimpleProductDao(){
        this.products = new ArrayList<>();

        this.products.add(new Product(1,"Shrimp","Seafood",12.99));
        this.products.add(new Product(2,"Cake Mix","Baking",1.99));
        this.products.add(new Product(3,"Lettuce","Fresh",2.99));
        this.products.add(new Product(4,"Sprinkles","Baking",1.99));
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

}
