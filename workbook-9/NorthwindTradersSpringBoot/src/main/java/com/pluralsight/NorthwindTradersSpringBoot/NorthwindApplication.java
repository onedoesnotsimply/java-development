package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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
			3) Delete Product
			4) Update Product
			""");

        int choice = scanner.nextInt();

        if (choice == 1) {
            displayProducts();

        } else if (choice == 2) {
            addProduct();
            displayProducts();

        } else if (choice == 3) {
            displayProducts();
            deleteProduct();

        } else if (choice == 4) {
            displayProducts();
            updateProduct();

        } else {
            System.out.println("Exiting program");
        }
    }

    public void updateProduct() {
        System.out.println("Enter the ID of the product you would like to update");
        int id = scanner.nextInt();

    }

    public void deleteProduct() {
        System.out.println("Enter the ID of the product you would like to delete");
        int id = scanner.nextInt();
        productDao.deleteProduct(id);
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

        productDao.persistProduct(new Product(name, cat, price));
    }
}
