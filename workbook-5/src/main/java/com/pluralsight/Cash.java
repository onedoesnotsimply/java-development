package com.pluralsight;

public class Cash extends AbstractAsset {

    public Cash(String description, String dateAquired, double originalCost) {
        super(description, dateAquired, originalCost);
    }

    public void addCash(double deposit) {
        setOriginalCost(getOriginalCost()+deposit);
        System.out.println("Added $"+deposit+" to the stash");
    }

    @Override
    public double getValue() {
        return getOriginalCost();
    }
}
