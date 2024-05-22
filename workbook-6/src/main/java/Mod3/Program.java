package Mod3;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Instantiate ArrayLists and Scanner, populate the people ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        populateList(people);
        ArrayList<Person> results = new ArrayList<>();

        // Prompt
        System.out.print("Enter the name you would like to search for : ");
        String name = scanner.nextLine();

        // Search
        for (Person person : people){
            if (person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name)){
                results.add(person);
            }
        }

        // Print the search results
        System.out.println("Results");
        for (Person person : results){
            System.out.println(person.getFirstName()+" "+person.getLastName());
        }
        System.out.println(" ");

        // Get the average age of the people on the list
        int sum = 0;
        for (Person person : people) {
            sum+= person.getAge();
        }
        System.out.println("The average age is : "+(sum/people.size()));

        // Get the youngest person in the list
        System.out.print("The youngest person is : ");
        int youngestAge = people.get(0).getAge();
        for (Person person : people){
            if (person.getAge() < youngestAge){
                youngestAge = person.getAge();
            }
        }
        // Print out the youngest age
        System.out.println(youngestAge);

        // Get the oldest person in the list
        System.out.print("The oldest person is : ");
        int age = 0;
        for (Person person : people){
            if (person.getAge() > age){
                age = person.getAge();
            }
        }
        // Print out the oldest age
        System.out.println(age);
    }

    public static void populateList(ArrayList<Person> people){
        people.add(new Person("Jayvon", "Fisher", 15));
        people.add(new Person("Jaron", "Lopez", 19));
        people.add(new Person("Ibrahim", "Leach", 47));
        people.add(new Person("Gemma", "Shelton", 26));
        people.add(new Person("Robert", "Odonnell", 74));
        people.add(new Person("Jazmine", "Browning", 35));
        people.add(new Person("Christopher", "Garza", 27));
        people.add(new Person("Maya", "Richmond", 26));
        people.add(new Person("Zane", "Ibrahim", 22));
        people.add(new Person("Oliver", "Henderson", 18));
    }
}
