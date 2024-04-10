package com.pluralsight;
import java.util.*;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt for fist float
        System.out.print("Enter first floating point number: ");
        float firstNum = scanner.nextFloat();
        // prompt for second float
        System.out.print("Enter second floating point number: ");
        float secondNum = scanner.nextFloat();
        // consume empty line
        scanner.nextLine();

        System.out.println("What do you want to do?");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");

        System.out.print("Input an option: ");
        char action = scanner.next().charAt(0);

        float answer;

        switch (action) {
            case 'a':
                answer = firstNum + secondNum;
                System.out.println(answer);
                break;

            case 's':
                answer = firstNum - secondNum;
                System.out.println(answer);
                break;

            case 'm':
                answer = firstNum * secondNum;
                System.out.println(answer);
                break;

            case 'd':
                answer = firstNum / secondNum;
                System.out.println(answer);
                break;
        }
    }

}
