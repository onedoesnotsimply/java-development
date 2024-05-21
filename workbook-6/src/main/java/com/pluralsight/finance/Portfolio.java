package com.pluralsight.finance;

import java.util.ArrayList;

public class Portfolio implements Valuable{
    private String name;
    private String owner;

    ArrayList<Valuable> assets;

    public Portfolio(String name, String owner){
        this.name=name;
        this.owner=owner;

        assets = new ArrayList<>();
    }

    public void addAsset(Valuable asset){
        assets.add(asset);
    }

    public Valuable getMostValuable() {
        Valuable valuable = null;
        double value = 0;
        for (Valuable asset : assets) {
            if (asset.getValue()>value && (!(asset instanceof CreditCard))) {
                value = asset.getValue();
                valuable=asset;
            }
        }
        return valuable;
    }

    public Valuable getLeastValuable() {
        Valuable valuable = null;
        double value = assets.get(0).getValue();
        for (Valuable asset : assets) { // Rewrite to account for credit card
            if (asset.getValue()<value) {
                value = asset.getValue();
                valuable=asset;
            }
        }
        return valuable;
    }

    @Override
    public double getValue() {
        double value = 0;
        for (Valuable asset:assets){
            if (asset instanceof CreditCard) {
                value-=asset.getValue();
            } else {
                value+=asset.getValue();
            }
        }
        return value;
    }
}
