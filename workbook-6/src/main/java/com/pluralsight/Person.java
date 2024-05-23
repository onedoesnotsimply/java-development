package com.pluralsight;

public class Person implements Comparable {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "|" + firstName + " " + lastName + ", " + age + "|";
    }

    @Override
    public int compareTo(Object o) {
        // Compare last names
        if (this.lastName.compareTo(((Person) o).getLastName())==0) { // If the last names are the same
            // Compare first names
            if (this.firstName.compareTo(((Person) o).getFirstName()) == 0) { // If the first names are the same
                // Compare age
                if (this.age > ((Person) o).getAge()){
                    return 1;
                } else if (this.age==((Person) o).getAge()) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return this.firstName.compareTo(((Person) o).getFirstName());
            }
        } else {
            return this.lastName.compareTo(((Person) o).getLastName());
        }

    }
}
