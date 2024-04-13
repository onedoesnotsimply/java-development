import java.util.Scanner;

public class FullNameParser {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        nameParser();
    }

    static public void nameParser() {
        // Prompt user for their input format choice
        System.out.println("Please enter your name as (first last) or (first middle last) : ");
        String fullName = scanner.nextLine().trim();

        String[] splitName=fullName.split(" ");
        int numberOfNames = splitName.length;

        if (numberOfNames == 3){
            System.out.println("First name: "+splitName[0]);
            System.out.println("Middle name: "+splitName[1]);
            System.out.println("Last name: "+splitName[2]);
        } else if (numberOfNames == 2) {
            System.out.println("First name: "+splitName[0]);
            System.out.println("Middle name: (None)");
            System.out.println("Last name: "+splitName[1]);
        } else {
            System.out.println("Invalid input.");
        }


    }

}
