import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchInventory {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        for (int i = 0; i < inventory.size(); i++){
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price $%.2f\n", p.getId(),p.getName(),p.getPrice());
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads products into the inventory
        Product product1 = new Product(1, "item1", 5.99f);
        Product product2 = new Product(2, "item2", 4.50f);
        Product product3 = new Product(3, "item3", 2.99f);
        Product product4 = new Product(4, "item4", 11.99f);
        Product product5 = new Product(5, "item5", 9.99f);

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
