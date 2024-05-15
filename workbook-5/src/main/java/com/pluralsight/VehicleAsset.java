package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VehicleAsset extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public VehicleAsset(String description,String dateAquired, int originalCost, String makeModel,int year,int odometer){
        super(description,dateAquired,originalCost);
        this.makeModel=makeModel;
        this.year=year;
        this.odometer=odometer;
    }

    // Override methods
    @Override
    public double getValue(){
        // Get the cars age for comparison
        int age = (LocalDate.now().getYear()-year);
        // Initialize value
        double value = getOriginalCost();

        if (age >= 0 && age <= 3){
            value -= (0.03*age);
        } else if (age >= 4 && age <= 6) {
            value -= (0.06*age);
        } else if (age >= 7 && age <= 10) {
            value -= (0.08*age);
        } else if (age > 10) {
            value -= 1000;
        }
        String make = getMakeModel().split(" ")[0];
        if (make.equalsIgnoreCase("toyota") || make.equalsIgnoreCase("honda")) {
            return value;
        }
        // If it is not a toyota/honda
        if (getOdometer() > 100000) {
            value -= (0.25*value);
        }
        return value;


    }

    // Getters and setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
