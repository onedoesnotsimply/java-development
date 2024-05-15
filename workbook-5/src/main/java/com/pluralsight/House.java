package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;
    
    public House(String description,String dateAquired,double originalCost,String address,int condition, int squareFoot, int lotSize){
        super(description,dateAquired,originalCost);
        this.address=address;
        this.condition=condition;
        this.squareFoot=squareFoot;
        this.lotSize=lotSize;
    }

    // Override methods
    @Override
    public double getValue() {
        // Get the condition of the home
        int value = 0;
        // Check the condition
        if (getCondition() == 1) {
            value+=(180*getSquareFoot());
        } else if (getCondition()==2) {
            value+=(130*getSquareFoot());
        } else if (getCondition()==3) {
            value+=(90*getSquareFoot());
        } else if ((getCondition()==4)) {
            value+=(80*getSquareFoot());
        }
        value+=(0.25*getLotSize());

        return value;
    }
    
    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
