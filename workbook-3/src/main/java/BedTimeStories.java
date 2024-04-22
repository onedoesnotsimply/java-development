import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Allows the user to choose and print out one of three story files.
 */

public class BedTimeStories {
    // Initialize file stream/scanner
    static FileInputStream fis;
    static Scanner fileScanner;

    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner for prompting
        Scanner scanner = new Scanner(System.in);

        // Prompt user for which story they want
        System.out.println("Choose a story you would like to read:");
        System.out.println("1 - Goldilocks");
        System.out.println("2 - Hansel and Gretel");
        System.out.println("3 - Mary Had a Little Lamb");

        // Make sure that the user inputs a number
        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    storyReader("goldilocks.txt");
                    break;
                case 2:
                    storyReader("hansel_and_gretel.txt");
                    break;
                case 3:
                    storyReader("mary_had_a_little_lamb.txt");
                    break;
                default:
                    System.out.println("Number must be between 1-3");
                    return;
            }
            // Close file scanner
            fileScanner.close();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input: must be a number between 1-3");
            //e.printStackTrace();
        }

        // Close the input scanner
        scanner.close();
    }

    // Reads/prints preloaded txt files to the cli
    static void storyReader(String fileName) throws FileNotFoundException {
        // Create the file stream and scanner and input the file name
        fis = new FileInputStream(fileName);
        fileScanner = new Scanner(fis);

        // Initialize file input and line counter variables
        String input;
        int lineCounter=1;

        // Read and print the file
        while(fileScanner.hasNextLine()) {
            input = fileScanner.nextLine();
            System.out.println(lineCounter+" "+input);
            lineCounter++;
        }

    }

}
