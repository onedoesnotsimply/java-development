import java.util.Scanner;

public class FamousQuotes {
    /*
    Allows the user to select one of 10 quotes from an array.
    Handles exceptions and doesn't break the loop unless the user chooses exit.
     */

    // Initialize the scanner object and String array
    static Scanner scanner = new Scanner(System.in);
    static String[] quotes = new String[10];

    public static void main(String[] args) {
        // Call the preLoad method to populate the quotes array
        preLoadQuotesArray();

        // Prompt for user input
        System.out.println("Please enter one of the following:");
        System.out.println("1-10 - For a quote from the list");

        try { // Only runs of the input is a number between 1-10 (prevents input letters from breaking the code as well)
            // Scan for users choice
            int choice = scanner.nextInt();
            System.out.println(" "); // Make the terminal a little easier to read
            // Print out what the user typed
            System.out.println(quotes[choice-1]);
        }
        catch (Exception e) { // If the index is invalid or a letter instead of a number
            System.out.println("Invalid index");
            System.out.println("Exiting program");
        }
        scanner.close();
    }

    static void preLoadQuotesArray() {
        // Populate the array with 10 quotes
        quotes[0] = "\"Fortune favors the bold.\" – Virgil";
        quotes[1] = "\"I think, therefore I am.\" - René Descartes";
        quotes[2] = "\"Time is money.\" - Benjamin Franklin";
        quotes[3] = "\"I came, I saw, I conquered.\" - Julius Caesar";
        quotes[4] = "\"When life gives you lemons, make lemonade.\" - Elbert Hubbard";
        quotes[5] = "\"Practice makes perfect.\" - Vince Lombardi";
        quotes[6] = "\"Knowledge is power.\" - Francis Bacon";
        quotes[7] = "\"Now I am become death, the destroyer of worlds.\" - J. Robert Oppenheimer";
        quotes[8] = "\"The only true wisdom is in knowing that you know nothing.\" - Socrates";
        quotes[9] = "\"Any fool can know. The point is to understand.\" - Albert Einstein";
    }
}
