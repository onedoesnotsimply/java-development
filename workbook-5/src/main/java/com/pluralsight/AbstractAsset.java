package com.pluralsight;

public abstract class AbstractAsset {
    private String description;
    private String dateAquired;
    private double originalCost;

    public AbstractAsset(String description, String dateAquired, double originalCost) {
        this.description=description;
        this.dateAquired=dateAquired;
        this.originalCost=originalCost;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAquired() {
        return dateAquired;
    }

    public void setDateAquired(String dateAquired) {
        this.dateAquired = dateAquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }

    // Methods for overriding
    public abstract double getValue();
}
