package com.pluralsight;

public class SemiTruck extends Vehicle {
    private boolean hasTrailer;

    public SemiTruck(int fuelCapacity, int numberOfPassengers, double cargoCapacity, double weight, String make, String model, String color, boolean hasTrailer) {
        super(fuelCapacity,numberOfPassengers,cargoCapacity,weight,make,model,color);
        this.hasTrailer=hasTrailer;
    }

    public boolean getTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }
}
