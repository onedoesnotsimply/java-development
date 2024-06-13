import com.pluralsight.DataManager;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Main {
    // Create data source
    static BasicDataSource dataSource = new BasicDataSource();
    public static void main(String[] args) {
        // Configure the data source
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        // Call homescreen
        homeScreen();
    }

    public static void homeScreen() {
        // Create the data manager
        DataManager dataManager = new DataManager(dataSource);

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                1) Search for customer order history
                2) Search for sales by year
                3) Search for sales by category
                0) Exit
                """);

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice==1){
            // prompt for a customer id
            System.out.println("Enter a customer ID");
            String custId = scanner.nextLine();
            dataManager.getCustomerOrderHistory(custId);
            homeScreen();
        } else if (choice==2) {
            homeScreen();
        } else if (choice==3) {
            homeScreen();
        } else if (choice==0) {
            System.exit(0);
        } else {
            System.out.println("index out of range");
            scanner.nextLine();
            homeScreen();
        }
    }

}
