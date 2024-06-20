package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.DAO.ProductDao;
import com.pluralsight.NorthwindTradersAPI.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private ProductDao productDao;

    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired


    @RequestMapping(path="/products", method=RequestMethod.GET)
    public List<Product> getProducts() {

        List<Product> products = productDao.getAll();
        /*

        products.add(new Product(1, "Shrimp", 8, 12.99));
        products.add(new Product(2, "Cake Mix", 3, 1.99));
        products.add(new Product(3, "Spinach", 7, 2.5));
        products.add(new Product(4, "Sprinkle", 3, 1.99));

         */

        return products;
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        /*List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Shrimp", 8, 12.99));
        products.add(new Product(2, "Cake Mix", 3, 1.99));
        products.add(new Product(3, "Spinach", 7, 2.5));
        products.add(new Product(4, "Sprinkles", 3, 1.99));

         */

        Product product = productDao.getProductById(id);

        return product;
    }
}