package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.DAO.ProductDao;
import com.pluralsight.NorthwindTradersAPI.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return products;
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        Product product = productDao.getProductById(id);
        return product;
    }

    @RequestMapping(path="/products", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        Product newProduct = productDao.insertProduct(product);
        return product;
    }

    @RequestMapping(path="/products/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product){
        productDao.updateProduct(id, product);
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id){
        productDao.deleteProduct(id);
    }
}