package com.pluralsight;
import java.util.Scanner;

public class RentalCarCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Input pickup date: ");
        String pickUpDate = scanner.nextLine();

        System.out.print("Input number of days you will rent for: ");
        int numberOfDays = scanner.nextInt();

        System.out.print("Input your current age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        double priceOfAddOns = OptionalAddOns(numberOfDays);

        System.out.println("Your rental will cost you a total of $"+CalculateCost(age,priceOfAddOns,numberOfDays));
    }

    static double OptionalAddOns(int daysRented){
        double price = 0;

        System.out.print("Would you like to add an electronic toll tag for an additional $3.95/day? (yes/no) : ");
        String optTag = scanner.nextLine();
        System.out.print("Would you like to add a GPS for an additional $2.95/day? (yes/no) : ");
        String optGPS = scanner.nextLine();
        System.out.print("Would you like to add roadside assistance for an additional $3.95/day? (yes/no) : ");
        String optRoadSide = scanner.nextLine();

        if (optTag.equalsIgnoreCase("yes")){
            price += (3.95*daysRented);
        }
        if (optGPS.equalsIgnoreCase("yes")){
            price += (2.95*daysRented);
        }
        if (optRoadSide.equalsIgnoreCase("yes")){
            price += (3.95*daysRented);
        }
        return price;
    }

    static double CalculateCost(int age, double priceOfAddOns, int daysRented){
        double basePrice = 29.99;
        double surcharge = 0;
        if (age < 25) {
             surcharge = 0.3;
        }

        return ((basePrice*daysRented)+priceOfAddOns)*surcharge;

    }
}
