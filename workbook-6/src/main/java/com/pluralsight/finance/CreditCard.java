package com.pluralsight.finance;

public class CreditCard implements Valuable {
    private String name;
    private String cardNumber;
    private double balance;

    public CreditCard(String name, String cardNumber, double balance){
        this.name=name;
        this.cardNumber=cardNumber;
        this.balance=balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void charge(double amount) {
        balance-=amount;
    }

    public void pay(double amount) {
        balance+=amount;
    }

    @Override
    public double getValue() {
        return balance;
    }
}
