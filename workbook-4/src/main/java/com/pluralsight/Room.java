package com.pluralsight;

public class Room {
    private int numberOfBeds;
    //private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, /*double price,*/ boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        //this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    /*
    public double getPrice() {
        return price;
    }
    */

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        if ((!occupied) && (!dirty)) {
            return true;
        }
        return false;
    }

    public void checkIn() {
        if (isAvailable()){
            this.occupied = true;
            this.dirty = true;
        } else {
            System.out.println("Room not available");
        }

    }

    public void checkOut() {
        this.occupied = false;
        this.dirty = true;
    }

    public void cleanRoom() {
        this.dirty = false;
    }
}
