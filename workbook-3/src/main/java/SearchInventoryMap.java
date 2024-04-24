import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {
    // Initialize the HashMap
    static HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();

    public static void main(String[] args) {
        // Load the items into the HashMap
        readCSV();

        // Create a scanner object for prompting
        Scanner scanner = new Scanner(System.in);

        while(true){
            // Prompt the user for the item id
            System.out.print("What item # are you interested in? ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Product matchedProduct = inventory.get(id);

            // If .get() returns null print an error message and quit the program
            if (matchedProduct == null){
                System.out.println("We don't carry that product");
                scanner.close();
                return;
            }

            // Print the item and close the scanner object
            System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(),matchedProduct.getPrice());
            System.out.println(" ");
            System.out.println(" ");
            // Prompt whether they want to search for another item
            System.out.print("Would you like to search again? (Y/N) : ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")){ // If yes
                continue; // Continue to the next iteration of the loop
            } else{
                scanner.close(); // Close the scanner
                return; // End the program
            }
        }

        /* Loop-less version

        // Prompt the user for the item id
        System.out.print("What item # are you interested in? ");
        int id = scanner.nextInt();
        Product matchedProduct = inventory.get(id);

        // If .get() returns null print an error message and quit the program
        if (matchedProduct == null){
            System.out.println("We don't carry that product");
            scanner.close();
            return;
        }

        // Print the item and close the scanner object
        System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(),matchedProduct.getPrice());
        scanner.close();
         */
    }

    public static void readCSV(){
        // Make sure that the file is there
        try{
            // Create bfr
            BufferedReader bfr = new BufferedReader(new FileReader("inventory.csv"));
            // Initialize input string
            String input;
            boolean skippedHeader=false;

            while((input = bfr.readLine()) != null){
                if (skippedHeader == false){
                    skippedHeader=true;
                    continue;
                }
                // Sends input to a constructor method
                loadInventory(input);
            }
            // Closes the buffered reader
            bfr.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadInventory(String input){
        // Create the tokens array
        String[] tokens=input.split("\\|");

        // Parse the tokens
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        float price = Float.parseFloat(tokens[2]);

        // Create and populate the Product object
        Product product = new Product(id,name,price);

        // Add the Product to the HashMap
        inventory.put(id, product);

    }


    public static class Product {
        private int id;
        private String name;
        private float price;

        public Product(int id, String name, float price){
            this.id = id;
            this.name = name;
            this.price = price;
        }
        public int getId() {
            return this.id;
        }
        public String getName() {
            return this.name;
        }
        public float getPrice() {
            return this.price;
        }
    }

}
