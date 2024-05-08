package com.pluralsight;

public class NameFormatter {

    private NameFormatter(String firstName, String lastName){}

    // Create our static methods
    public static String format(String firstName, String lastName){
        return String.format("%s, %s", lastName, firstName);
    }
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix){
        return String.format("%s, %s %s %s, %s", lastName, prefix, firstName, middleName, suffix);
    }
    public static String format(String fullName){
        String[] tokens = fullName.split(" ");
        // tokens
        if (tokens.length == 5){
            return String.format("%s %s %s %s, %s", tokens[3],tokens[0],tokens[1],tokens[2],tokens[4]);
        } else if (tokens.length == 4) {
            return String.format("%s %s %s, %s", tokens[2],tokens[0],tokens[1],tokens[3]);
        } else if (tokens.length == 3) {
            return String.format("%s %s %s", tokens[1], tokens[0],tokens[2]);
        } else { //tokens.length == 2
            return String.format("%s, %s", tokens[1],tokens[0]);
        }
    }
}
