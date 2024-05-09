package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit=suit;
        this.value=value;
    }

    // Getters only return values if the card is face up
    public String getSuit(){
        if (isFaceUp){
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        if (isFaceUp){
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        int pointValue=0;
        if (isFaceUp) {
            if (value.equals("A")){
                pointValue = 11;
            } else if (value.equals("K")||value.equals("Q")||value.equals("J")) {
                pointValue = 10;
            } else {
                pointValue = Integer.parseInt(value);
            }
        }
        return pointValue;
    }

    // Boolean getter
    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp=!isFaceUp;
    }
}
