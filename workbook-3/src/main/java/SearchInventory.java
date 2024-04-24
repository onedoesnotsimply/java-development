import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventory {
    // Initialize ArrayList
    static ArrayList<Product> csvInventory = new ArrayList<Product>();

    public static void main(String[] args) {
        // Get first inventory
        ArrayList<Product> inventory = getInventory();

        // Populate the CSV
        readFromFile("inventory.csv");

        // Print out the pre loaded inventory
        System.out.println("Pre loaded inventory :");
        for (int i = 0; i < inventory.size(); i++){
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price $%.2f\n", p.getId(),p.getName(),p.getPrice());
        }

        System.out.println(" "); // Make the terminal look better

        // Get second inventory
        System.out.println("CSV inventory :");
        for (int i = 0; i < csvInventory.size(); i++){
            Product p = csvInventory.get(i);
            System.out.printf("id: %d %s - Price $%.2f\n", p.getId(),p.getName(),p.getPrice());
        }
    }

    public static void readFromFile(String filename){
        // Try to open the file
        try{
            BufferedReader bfr = new BufferedReader(new FileReader("inventory.csv"));
            String input;
            boolean skippedHeader = false;

            while ((input = bfr.readLine()) != null){
                if (!skippedHeader){
                    skippedHeader = true;
                    continue;
                }
                // Populate the CSV inventory
                getCSVInventory(input);
            }
            bfr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Populate the CSV inventory
    public static void getCSVInventory(String input) {
        // split the input
        String[] tokens = input.split("\\|");

        // Parse the tokens
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        float price = Float.parseFloat(tokens[2]);

        // Creates the product
        Product product = new Product(id, name, price);

        // Adds the product to csvInventory
        csvInventory.add(product);
    }

    
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads products into the inventory
        Product product1 = new Product(1, "item1", 5.99f);
        Product product2 = new Product(2, "item2", 4.50f);
        Product product3 = new Product(3, "item3", 2.99f);
        Product product4 = new Product(4, "item4", 11.99f);
        Product product5 = new Product(5, "item5", 9.99f);

        // Add items to the inventory
        inventory.add(product1);
        inventory.add(product2);
        inventory.add(product3);
        inventory.add(product4);
        inventory.add(product5);

        return inventory;
    }

    public static class Product {
        private int id;
        private String name;
        private float price;
        public Product(int id, String name, float price) {
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
