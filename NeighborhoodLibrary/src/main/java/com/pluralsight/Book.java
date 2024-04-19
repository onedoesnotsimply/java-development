package com.pluralsight;

public class Book {
    // Instance variables
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    // Constructor
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo){
        this.id=id;
        this.isbn=isbn;
        this.title=title;
        this.isCheckedOut=isCheckedOut;
        this.checkedOutTo=checkedOutTo;
    }

    // Methods
    // Check out method
    public void checkOut(String name){
        this.isCheckedOut = true; // Sets is checked out to true
        this.checkedOutTo=name; // Saves the name of the person that checked out the book
    }

    // Check in method
    public void checkIn() {
        this.checkedOutTo=""; // Sets the checked out to variable for this book to an empty string
        this.isCheckedOut=false; // Sets is checked out for this book to false
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
}
