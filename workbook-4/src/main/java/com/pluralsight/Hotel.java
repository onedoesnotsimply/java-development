package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedSuites, int bookedRooms){
        this.name = name;
        this.numberOfRooms=numberOfRooms;
        this.numberOfSuites=numberOfSuites;
        this.bookedSuites=bookedSuites;
        this.bookedRooms=bookedRooms;
    }

    public Hotel(String name, int numberOfRooms, int numberOfSuites){
        this.name=name;
        this.numberOfSuites=numberOfSuites;
        this.numberOfRooms=numberOfRooms;
        this.bookedSuites=0;
        this.bookedRooms=0;
    }

    // Derived getters

    // Allows users to book multiple rooms at a time and choose between a suite or a basic room
    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        // If the room is a suite
        if (isSuite){
            // If the number of suites the user wishes to book are available
            if ((this.numberOfSuites-this.bookedSuites)>=numberOfRooms){
                // Update the number of booked suits
                this.bookedSuites+=numberOfRooms;
                // And return true
                return true;
            } else { // If the
                return false;
            }
        }
        if ((this.numberOfRooms-this.bookedRooms) >= numberOfRooms) {
            this.bookedRooms+=numberOfRooms;
            return true;
        } else{
            return false;
        }
    }

    public int getAvailableSuits(){
        return (this.numberOfSuites-this.bookedSuites);
    }

    public int getAvailableRooms(){
        return (this.numberOfRooms-this.bookedRooms);
    }
}
