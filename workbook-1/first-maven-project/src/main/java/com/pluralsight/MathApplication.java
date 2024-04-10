package com.pluralsight;

public class MathApplication {
    public static void main(String[] args) {

        // Question 1:
        int bobSalary = 53000;
        int garySalary = 72000;

        int highestSalary;

        // Find the highest salary
        highestSalary = Math.max(garySalary, bobSalary);
        // Print it to the screen
        System.out.println("The highest salary is " + highestSalary);

        // Question 2
        float carPrice = 34999.99f, truckPrice = 54999.99f;
        float lowestPrice = Math.min(carPrice, truckPrice);

        System.out.println("The lowest price is " + lowestPrice);

        // Question 3

        double radius = 7.25;
        double area = Math.PI * radius * radius;

        System.out.println("The area of the circle is " + area);

        // Question 4
        double num = 5.0;
        double squareRoot = Math.sqrt(num);

        System.out.println("The square root is " + squareRoot);

        // Question 5

        // the points
        int pointX1 = 5, pointY1 = 10, pointX2 = 85, pointY2 = 50;

        // find the difference
        int differenceX = pointX2 - pointX1;
        int differenceY = pointY2 - pointY1;

        // square values
        int differenceSquaredX = differenceX * differenceX;
        int differenceSquaredY = differenceY * differenceY;

        // add squared values together
        int sumDifference = differenceSquaredX + differenceSquaredY;

        // get the distance
        double distance = Math.sqrt(sumDifference);

        // print the difference
        System.out.println("The distance between points (5,10) and (85,50) is " + distance);

        // Question 6
        double negativeNum = -3.8;
        double absolute = Math.abs(negativeNum);

        System.out.println("The absolute positive value of -3.8 is " + absolute);

        // Question 7
        System.out.println("This is a random number between 0 and 1: " + Math.random());
    }
}
