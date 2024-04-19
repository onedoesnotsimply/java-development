import com.pluralsight.Book;

import java.util.Scanner;

public class NeighborhoodLibrary {
    static Book[] bookInventory = new Book[5]; // change to 20
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //TODO populate bookInventory
        bookInventory[0] = new Book(1, "123456", "Where the Red Fern Grows", false, "");
        bookInventory[1] = new Book(2, "453665", "A Dog's Way Home", false, "");
        bookInventory[2] = new Book(3, "176886", "This One Summer", false, "");
        bookInventory[3] = new Book(4, "966654", "Darkness Becomes Her", false, "");
        bookInventory[4] = new Book(5, "444566", "Do You Know Me?", false, "");


        // Display the home screen
        do {
            System.out.println(" ");
            System.out.println("Welcome to your neighborhood library!");
            System.out.println("What would you like to do?");
            System.out.println(" ");
            System.out.println("1 - Show available books");
            System.out.println("2 - Show checked out books");
            System.out.println("3 - Exit");

            // Get user command
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (command) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    break;
                case 3:
                    return; // When main returns the program quits
            }

        }
        while (true);

    }

    public static void showAvailableBooks() {
        // Display list of books
        for (Book book : bookInventory) {
            if (!(book.isCheckedOut())) {
                System.out.println(book);
                System.out.println(" ");
            }
        }
        System.out.println("Please either:");
        System.out.println("Enter the title of the book you would like to check out");
        System.out.println("Or exit to the main menu (please enter: X)");
        String command = scanner.nextLine();
        if (command.equalsIgnoreCase("x")){
            System.out.println("Exiting to main menu");
        } else {
            for(Book book:bookInventory){
                if (book.getTitle().equalsIgnoreCase(command)){
                    //Prompt for name
                    System.out.print("Please enter your name: ");
                    String name = scanner.nextLine();
                    //Set checked out to true and checked out by to name
                    book.setCheckedOut(true);
                    book.setCheckedOutTo(name);
                    break;
                }
            }
        }
    }



    public static void showCheckedOutBooks() {
        //
        for (Book book : bookInventory){
            if (book.isCheckedOut()){
                System.out.println(book);
            }
        }
    }
}
