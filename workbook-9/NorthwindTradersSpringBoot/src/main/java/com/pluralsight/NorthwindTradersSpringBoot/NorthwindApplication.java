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

        int choice = menu();

        while (choice!=0){
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

            } else if (choice == 5) {
                searchProduct();

            } else {
                System.out.println("index out of range");
            }
            choice = menu();
        }

        /*
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

        } else if (choice == 5) {
            //displayProducts();
            searchProduct();
        }
        else {
            System.out.println("index out of range");
        }
        */
    }

    public int menu() {
        System.out.println("""
			1) List all products
			2) Add a product
			3) Delete a product
			4) Update a product
			5) Search for a product
			0) Exit
			""");

        return scanner.nextInt();
    }

    public void searchProduct() {
        System.out.println("Enter the ID of a product");
        int id = scanner.nextInt();
        System.out.println(productDao.searchProduct(id));
    }

    public void updateProduct() {
        System.out.println("Enter the ID of the product you would like to update");
        int id = scanner.nextInt();
        System.out.println("Enter the updated name of the product");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the updated category of the product");
        String cat = scanner.nextLine();
        System.out.println("Enter the updated price of the product");
        double price = scanner.nextDouble();

        Product product = new Product(name,cat,price);
        productDao.updateProduct(id,product);
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
