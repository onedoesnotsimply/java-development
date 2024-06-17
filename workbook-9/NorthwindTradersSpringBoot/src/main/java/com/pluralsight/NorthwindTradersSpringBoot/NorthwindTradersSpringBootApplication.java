package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);


		SimpleProductDao simpleProductDao = (SimpleProductDao) applicationContext.getBean("simpleProductDao");

		Scanner scanner = new Scanner(System.in);


		System.out.println("""
			1) List Products
			2) Add Product
			""");

		int choice = scanner.nextInt();

		if (choice == 1) {
			List<Product> products = simpleProductDao.getAll();
			products.forEach(System.out::println);

		} else if (choice == 2) {
			scanner.nextLine();
			System.out.println("Enter the name of the product");
			String name = scanner.nextLine();
			System.out.println("Enter the category of the product");
			String cat = scanner.nextLine();
			System.out.println("Enter the price of the product");
			double price = scanner.nextDouble();

			int id = simpleProductDao.persistProduct(new Product(name, cat, price));

			System.out.println("Product registered with ID = " + id);
			List<Product> products = simpleProductDao.getAll();
			products.forEach(System.out::println);

		} else {
			System.out.println("Exiting program");
		}
	}
}



