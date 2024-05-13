package com.pluralsight;

public class Vehicle {
    private int fuelCapacity;
    private int numberOfPassengers;
    private double cargoCapacity;
    private int speed;
    private double weight;
    private String make;
    private String model;
    //private int xPosition;
    private String color;

    Vehicle(int fuelCapacity, int numberOfPassengers, double cargoCapacity, double weight, String make, String model, String color){
        this.fuelCapacity=fuelCapacity;
        this.numberOfPassengers=numberOfPassengers;
        this.cargoCapacity=cargoCapacity;
        this.speed=0;
        this.weight=weight;
        this.make=make;
        this.model=model;
        //this.xPosition=xPosition;
        this.color=color;
    }

    // Getters and setters
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /*
    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
     */

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
