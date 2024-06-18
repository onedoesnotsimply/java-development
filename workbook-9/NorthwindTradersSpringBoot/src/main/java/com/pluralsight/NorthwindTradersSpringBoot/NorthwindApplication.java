package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {

        System.out.println("""
			1) List Products
			2) Add Product
			""");

        int choice = scanner.nextInt();

        if (choice == 1) {
            displayProducts();

        } else if (choice == 2) {
            addProduct();
            displayProducts();

        } else {
            System.out.println("Exiting program");
        }
    }

    public void displayProducts() {
        List<Product> products = productDao.getAll();
        products.forEach(System.out::println);
    }

    public void addProduct() {
        scanner.nextLine();
        System.out.println("Enter the name of the product");
        String name = scanner.nextLine();
        System.out.println("Enter the category of the product");
        String cat = scanner.nextLine();
        System.out.println("Enter the price of the product");
        double price = scanner.nextDouble();

        int id = productDao.persistProduct(new Product(name, cat, price));

        System.out.println("Product registered with ID = " + id);
    }
}
