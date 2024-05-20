package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable{
    protected String name;
    protected double marketValue;

    public void Asset(String name, double marketValue){}

    @Override
    public double getValue() {
        return 0;
    }
}
