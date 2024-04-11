package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // prompt for sandwich size
        System.out.println("Choose sandwich size: ");
        System.out.println("1. Regular: $5.45");
        System.out.println("2. Large: $8.95");

        int sandwichType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        double price = 0;

        if (sandwichType == 1) {
            price = 5.45;
        } else if (sandwichType == 2) {
            price = 8.95;
        } else {
            System.out.println("Not a valid sandwich option.");
        }

        if (age <= 17) {
            price = price - (price*0.1);
        } else if (age >= 65) {
            price = price - (price*0.2);
        }

        System.out.printf("Your total is: $%.2f", price);
    }
}
