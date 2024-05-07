package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getPrice() {
        // If the roomType value is king
        if (roomType.equalsIgnoreCase("king")) {
            if (isWeekend) { // If it's a weekend
                // The daily cost of the room goes up by 10%
                return 139+(139*0.1);
            }
            // Return the weekday price of a king room
            return 139;
        }
        // There are only two options for roomType, so we don't need a second if for double
        if (isWeekend){
            // Calculate the weekend price
            return 124+(124*0.1);
        }
        return 124;
    }

    public double getReservationTotal() {
        // Calculate the total by getting the room price and multiplying it by the number of nights
        return (getPrice() * numberOfNights);
    }
}
