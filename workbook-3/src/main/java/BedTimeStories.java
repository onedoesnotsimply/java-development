import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedTimeStories {
    // Initialize file stream/scanner
    static FileInputStream fis;
    static Scanner fileScanner;

    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner for prompting
        Scanner scanner = new Scanner(System.in);



        // Prompt user for story title
        System.out.println("Choose a story you would like to read:");
        System.out.println("1 - Goldilocks");
        System.out.println("2 - Hansel and Gretel");
        System.out.println("3 - Mary Had a Little Lamb");

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
        }
    }

    static void storyReader(String fileName) throws FileNotFoundException {
        fis = new FileInputStream(fileName);
        fileScanner = new Scanner(fis);

        String input;
        int lineCounter=1;

        while(fileScanner.hasNextLine()) {
            input = fileScanner.nextLine();
            System.out.println(lineCounter+" "+input);
            lineCounter++;
        }

    }

}
