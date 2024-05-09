import com.pluralsight.NameFormatter;

import java.util.Scanner;

public class StaticClasses {
    public static void main(String[] args) {

        String name = NameFormatter.format("Dr.","Mel","B","Johnson","PhD");
        System.out.println(name);

        Scanner scanner = new Scanner(System.in);

        // Prompt for the first and last name
        System.out.print("Please enter your first name : ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter your last name : ");
        String lastName = scanner.nextLine();
        String formattedName = NameFormatter.format(firstName,lastName);
        System.out.println(formattedName);
    }
}
