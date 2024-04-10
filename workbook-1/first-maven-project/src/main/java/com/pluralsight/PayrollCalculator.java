package com.pluralsight;
import java.util.*;


public class PayrollCalculator {
    // Create a public scanner
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Prompt for name
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        // Prompt for hours worked
        System.out.print("Hours worked: ");
        float hours = scanner.nextFloat();

        // Prompt for pay rate
        System.out.print("Pay rate: ");
        float rate = scanner.nextFloat();

        // Calculate and display gross pay
        float grossPay;

        if (hours > 40) {
            grossPay = (float) ((40*rate)+((hours-40)*(rate*1.5)));
        }
        else {
            grossPay = hours * rate;
        }

        System.out.println(name+" has made $"+grossPay+" gross pay.");

    }
}
