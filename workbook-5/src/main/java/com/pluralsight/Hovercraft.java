package com.pluralsight;

public class Hovercraft extends Vehicle{
    private int yPosition;

    public Hovercraft(int fuelCapacity, int numberOfPassengers, double cargoCapacity, double weight, String make, String model, String color, int yPosition){
        super(fuelCapacity,numberOfPassengers,cargoCapacity,weight,make,model,color);
        this.yPosition=yPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
