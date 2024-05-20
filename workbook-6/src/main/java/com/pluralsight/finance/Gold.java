package com.pluralsight.finance;

public class Gold extends FixedAsset{
    private double weight;


    public Gold(double weight){
        this.weight=weight;
    }

    @Override
    public double getValue() {
        return this.marketValue;
    }
}
