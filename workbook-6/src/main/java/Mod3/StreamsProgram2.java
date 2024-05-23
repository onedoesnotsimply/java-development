package Mod3;

import com.pluralsight.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProgram2 {
    public static void main(String[] args) {
        // Instantiate Scanner and List
        Scanner scanner = new Scanner(System.in);
        List<Person> people = Arrays.asList(new Person("Jayvon", "Fisher", 15),
                new Person("Jaron", "Lopez", 19),new Person("Ibrahim", "Leach", 47),
                new Person("Gemma", "Shelton", 26),new Person("Robert", "Odonnell", 74),
                new Person("Jazmine", "Browning", 35),new Person("Christopher", "Garza", 27),
                new Person("Maya", "Richmond", 26),new Person("Zane", "Ibrahim", 22),
                new Person("Oliver", "Henderson", 18));

        // Search for a name
        System.out.print("Enter the name you want to search for : ");
        String name = scanner.nextLine();
        people.stream()
                .filter(person -> (person.getLastName().toLowerCase().contains(name) || person.getFirstName().toLowerCase().contains(name)))
                .forEach(System.out::println);

        // Get average age
        int sum = people.stream().mapToInt(Person::getAge).sum();
        int avg = (sum/people.size());

        /* //Sum age using reduce()
        int sum = people.stream().mapToInt(person -> person.getAge())
                .reduce(0, (temp, person)-> temp += person);
         */

        // Get the oldest persons age
        int oldest = people.stream().mapToInt(Person::getAge).max().getAsInt();

        // Get the youngest persons age
        int youngest = people.stream().mapToInt(Person::getAge).min().getAsInt();

        /*
        // Sort the entire list by age (oldest first)
        List<Person> sortedPeople = people.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge())).toList();
        // Get the oldest
        System.out.println(sortedPeople.get(0));
        // Get the youngest
        System.out.println(sortedPeople.get(sortedPeople.size()-1));
         */

        System.out.println("Average age : "+avg);
        System.out.println("Oldest : "+oldest);
        System.out.println("Youngest : "+youngest);
    }
}
