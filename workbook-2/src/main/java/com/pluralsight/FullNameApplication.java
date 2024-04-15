package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    static Scanner scanner = new Scanner(System.in);

    public static String namePrompt() {

        System.out.println("Please enter your name");
        // Prompt for users name
        // First
        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();

        // Middle
        System.out.print("Middle name: ");
        String middleName = scanner.nextLine().trim();

        // Last
        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();

        // Suffix
        System.out.print("Suffix: ");
        String suffix = scanner.nextLine().trim();

        // Initialize variables
        String results;
        String fullName;

        // If user doesn't input a middle name or suffix
        if (middleName.isEmpty() && suffix.isEmpty()){
            results = "%s %s";
            fullName = String.format(results, firstName,lastName);
        } else if (middleName.isEmpty()){ // If they do
            results = "%s %s, %s";
            fullName = String.format(results, firstName, lastName,suffix);
        } else {
            results = "%s %s %s, %s";
            fullName = String.format(results, firstName,middleName,lastName,suffix);
        }

        return fullName;
    }
}
