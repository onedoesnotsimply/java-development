package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedRooms;

    public House(int yearBuilt, int squareFeet, int bedRooms) {
        this.yearBuilt=yearBuilt;
        this.squareFeet=squareFeet;
        this.bedRooms=bedRooms;
    }

    @Override
    public double getValue() {
        return this.marketValue;
    }
}
