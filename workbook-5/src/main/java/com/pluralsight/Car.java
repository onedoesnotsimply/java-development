package com.pluralsight;

public class Car extends Vehicle{
    private String type;
    private boolean isConvertible;

    public Car(int fuelCapacity, int numberOfPassengers, double cargoCapacity, double weight, String make, String model, String color, String type, boolean isConvertible){
        super(fuelCapacity,numberOfPassengers,cargoCapacity,weight,make,model,color);
        this.type=type;
        this.isConvertible=isConvertible;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }
}
