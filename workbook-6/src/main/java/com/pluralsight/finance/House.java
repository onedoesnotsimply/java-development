package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedRooms;

    public House(String name, double marketValue, int yearBuilt, int squareFeet, int bedRooms) {
        super(name,marketValue);
        this.yearBuilt=yearBuilt;
        this.squareFeet=squareFeet;
        this.bedRooms=bedRooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "yearBuilt=" + yearBuilt +'\''+
                ", squareFeet=" + squareFeet +'\''+
                ", bedRooms=" + bedRooms +'\''+
                ", name='" + name + '\'' +
                ", marketValue=" + marketValue +
                '}';
    }

    @Override
    public double getValue() {
        return this.marketValue;
    }
}
