import com.pluralsight.Book;

import java.util.Scanner;

public class NeighborhoodLibrary {
    /*
    A library catalog that allows the user to view available and checked out books
    as well as check them out and return them themselves.
     */

    // Initialize the bookInventory array and scanner object
    static Book[] bookInventory = new Book[20];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Preload the books
        bookInventory[0] = new Book(1, "111", "Where the Red Fern Grows", false, "");
        bookInventory[1] = new Book(2, "222", "A Dog's Way Home", false, "");
        bookInventory[2] = new Book(3, "333", "This One Summer", false, "");
        bookInventory[3] = new Book(4, "444", "Darkness Becomes Her", false, "");
        bookInventory[4] = new Book(5, "555", "Do You Know Me?", false, "");
        bookInventory[5] = new Book(6, "666", "The Star Outside My Window", false, "");
        bookInventory[6] = new Book(7, "777", "Harry Potter", false, "");
        bookInventory[7] = new Book(8, "888", "The Lord of the Rings", false, "");
        bookInventory[8] = new Book(9, "999", "Granted", false, "");
        bookInventory[9] = new Book(10, "101", "The Girl At Midnight", false, "");
        bookInventory[10] = new Book(11, "202", "Hope Was Here", false, "");
        bookInventory[11] = new Book(12, "303", "Windborn", false, "");
        bookInventory[12] = new Book(13, "404", "Tuck Everlasting", false, "");
        bookInventory[13] = new Book(14, "505", "Nowhere Wild", false, "");
        bookInventory[14] = new Book(15, "606", "Bob", false, "");
        bookInventory[15] = new Book(16, "707", "The Dark Wild", false, "");
        bookInventory[16] = new Book(17, "808", "Shrimp", false, "");
        bookInventory[17] = new Book(18, "909", "Do You Know Me?", false, "");
        bookInventory[18] = new Book(19, "010", "Strays Line Us", false, "");
        bookInventory[19] = new Book(20, "020", "The Skeleton Tree", false, "");


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
                    showCheckedOutBooks();
                    break;
                case 3:
                    return; // When main returns the program quits.
                default:
                    System.out.println("Invalid input");
                    return;
            }

        }
        while (true);

    }

    public static void showCheckedOutBooks() {
        // Display list of checked out books
        for (Book book : bookInventory) {
            if (book.isCheckedOut()){
                System.out.println(book+" "+book.getCheckedOutTo());
            }
        }
        // Prompt for check in or exiting to menu
        System.out.println("What would you like to do?");
        System.out.println("Check in a book (C)");
        System.out.println("Exit to main menu (X)");
        String command = scanner.nextLine();
        // If user wishes to check in a book
        if (command.equalsIgnoreCase("c")) {
            checkInBook(); // Call the check in method
        }
    }

    public static void checkInBook() {
        // Prompt user for the book id
        System.out.println("Please enter the id of the book you want to return: ");
        int id = scanner.nextInt();

        // For books in bookInventory
        for (Book book : bookInventory) {
            if (book.getId()==id){ // If id matches bookId
                book.checkIn(); // Check in the book
                System.out.println(book.getTitle()+" was checked in");
            }
        }
    }

    public static void showAvailableBooks() {
        // Display list of books
        for (Book book : bookInventory) {
            if (!(book.isCheckedOut())) {
                System.out.println(book);
            }
        }
        // prompt for checkout or exiting to menu
        System.out.println("What would you like to do?");
        System.out.println("Check out a book (C)");
        System.out.println("Exit to main menu (X)");
        String command = scanner.nextLine();
        // If user wishes to check out a book
        if (command.equalsIgnoreCase("c")){
            checkOutBook(); // Call the check out method
        }

    }

    public static void checkOutBook() {
        // Prompt for the id of the book
        System.out.println("Please enter the id of the book you want to check out: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        // Prompt for name
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        // For each book in bookInventory
        for (Book book : bookInventory) {
            if (book.getId()==id){ // If the book id matches the input it
                book.checkOut(name); // Check the book out
                System.out.println(book.getTitle()+" was checked out by "+name);
            }
        }
    }
}
