package com.pluralsight;

public class Moped extends Vehicle{
    private double balance;

    public Moped(int fuelCapacity, int numberOfPassengers, double cargoCapacity, double weight, String make, String model, String color, double balance) {
        // Pass the arguments from vehicle to the super() function
        super(fuelCapacity,numberOfPassengers, cargoCapacity,weight,make,model,color);
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
