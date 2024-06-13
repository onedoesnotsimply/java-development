import com.pluralsight.DataManager;
import org.apache.commons.dbcp2.BasicDataSource;

import java.time.LocalDate;
import java.util.InputMismatchException;
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
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice==1){
                // prompt for a customer id
                System.out.println("Enter a customer ID");
                String custId = scanner.nextLine();

                dataManager.getCustomerOrderHistory(custId);
                homeScreen();

            } else if (choice==2) {
                // Prompt for a start and end date
                System.out.println("Enter start date");
                LocalDate startDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter end date");
                LocalDate endDate = LocalDate.parse(scanner.nextLine());
                
                dataManager.getSalesByYear(startDate,endDate);
                homeScreen();

            } else if (choice==3) {
                // Prompt for (string) category and year
                System.out.println("Enter category name");
                String category = scanner.nextLine();
                System.out.println("Enter year");
                int year = scanner.nextInt();

                dataManager.getSalesByCategory(category,year);
                homeScreen();

            } else if (choice==0) {
                System.exit(0);
            } else {
                System.out.println("index out of range");
                scanner.nextLine();
                homeScreen();
            }
        } catch (Exception e){
            System.out.println("ERROR : incorrect input");
            homeScreen();
        }
    }
}
