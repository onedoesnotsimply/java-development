package com.pluralsight.finance;

public class BankAccount implements Valuable{
    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double balance){
        this.name=name;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void withdraw(double amount){
        // Check whether the amount can be withdrawn from the account
        if ((balance-=amount)<0) {
            // Print an error message
            System.out.println("Unable to withdraw amount\nAccount balance would be negative");
        } else{ // Else, subtract the amount from balance and print a success message
            balance-=amount;
            System.out.printf("Successfully withdrew $%.2f\nRemaining balance : $%.2f\n",amount,balance);
        }
    }



    public void deposit(double amount){
        // Add the deposited amount to balance
        balance+=amount;
        System.out.printf("Deposited $%.2f into account\nThe new balance is $%.2f\n",amount,balance);
    }

    @Override
    public double getValue() {
        return balance;
    }
}
