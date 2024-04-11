package com.pluralsight;
import java.util.Scanner;

public class PayrollCalculator2 {
    static Scanner scanner = new Scanner(System.in);

    public static float getFloat(Scanner scanner) {
        // get float
        float num = scanner.nextFloat();
        // consume newline
        scanner.nextLine();
        // return float
        return num;
    }

    public static float calculateGrossPay(float payRate, float hours) {
        // initialize variable
        float grossPay;
        // calculate gross pay
        if (hours > 40) {
            grossPay = (float) ((40*payRate)+((hours-40)*(payRate*1.5)));
        }
        else {
            grossPay = hours * payRate;
        }
        // return the value
        return grossPay;
    }

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Hours worked: ");
        float hours = getFloat(scanner);
        System.out.print("Pay rate: ");
        float payRate = getFloat(scanner);

        float grossPay = calculateGrossPay(payRate, hours);
        System.out.println(name+" gets paid $"+grossPay+" gross pay.");
    }
}
