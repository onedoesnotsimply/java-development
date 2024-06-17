package com.pluralsight;

import com.pluralsight.dao.ProductDao;
import com.pluralsight.dao.SimpleProductDao;
import com.pluralsight.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Open beans.xml where in this file there is a directive
        // called component-scan Spring scans the files in the
        // package declared looking for annotations like
        // @Component and @Autowired. Spring will then do the
        // wiring for you.

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        // Pluck out the Registration Service from Spring. Think
        // of your application like black box and you are asking
        // for a component of a certain type.
        // RegistrationService will already have the
        // DataAccessObject injected into it by the time
        // you receive this reference
        SimpleProductDao simpleProductDao = ctx.getBean(SimpleProductDao.class);

        System.out.println("""
                1) List Products
                2) Add Product
                """);

        int choice = scanner.nextInt();

        if (choice==1){
            List<Product> products = simpleProductDao.getAll();
            products.forEach(System.out::println);

        } else if (choice==2) {
            scanner.nextLine();
            System.out.println("Enter the name of the product");
            String name = scanner.nextLine();
            System.out.println("Enter the category of the product");
            String cat = scanner.nextLine();
            System.out.println("Enter the price of the product");
            double price = scanner.nextDouble();

            int id = simpleProductDao.persistProduct(new Product(name,cat,price));

            System.out.println("Product registered with ID = "+id);
        } else {
            System.out.println("Exiting program");
        }

    }
}
