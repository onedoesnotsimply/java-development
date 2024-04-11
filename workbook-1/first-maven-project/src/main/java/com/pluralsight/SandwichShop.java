package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // prompt for sandwich size
        System.out.println("1. Regular: $5.45");
        System.out.println("2. Large: $8.95");
        System.out.print("Choose sandwich size: ");

        // get the sandwich number
        int sandwichType = scanner.nextInt();
        scanner.nextLine();

        // prompt for loaded or not
        System.out.print("Would you like that loaded? (Yes/No) ");
        String loaded = scanner.nextLine();

        // prompt for age for potential discount
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // initialize price
        double price = 0;


        if (sandwichType == 1) {
            price = 5.45;
        } else if (sandwichType == 2) {
            price = 8.95;
        } else {
            System.out.println("Not a valid sandwich option.");
        }

        if (age <= 17) {
            price = price - (price * 0.1);
        } else if (age >= 65) {
            price = price - (price * 0.2);
        }

        if (loaded.equalsIgnoreCase("yes") && sandwichType == 1) {
            price += 1.0;
        } else if (loaded.equalsIgnoreCase("yes") && sandwichType == 2) {
            price += 1.75;
        }

        System.out.printf("Your total is: $%.2f", price);
    }

}
