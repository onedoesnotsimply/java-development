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
    public int compareTo(Object o) {
        if (o instanceof Person) {
            int comparedNameValue = this.lastName.compareTo(((Person) o).getLastName());
            if (comparedNameValue == 1);

        }

    }
}
