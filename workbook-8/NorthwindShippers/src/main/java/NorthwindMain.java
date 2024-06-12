import com.pluralsight.Shipper;
import com.pluralsight.ShippersDao;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NorthwindMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set up the dataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        // Create the data manager
        ShippersDao dataManager = new ShippersDao(dataSource);

        // Prompt for shipper data
        System.out.println("Enter the name of your shipping company");
        String companyName = scanner.nextLine();
        System.out.println("Enter the company phone number");
        String phone = scanner.nextLine();

        // Run the insert
        dataManager.insertShipper(companyName,phone);
        
        // Run display all
        List<Shipper> shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);

        // Prompt to change phone number of a shipper (ask for id and new phone)
        System.out.println("Enter the ID of a shipping company");
        int updateId = scanner.nextInt();
        System.out.println("Enter a new phone number for this company");
        scanner.nextLine(); // Consume the newline
        String updatePhone = scanner.nextLine();

        // Run the update
        dataManager.updateShipper(updateId,updatePhone);

        // Display all again, updating shippers with the new data
        shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);

        // Prompt the user to delete a shipper (Delete what we added)
        System.out.println("Enter the ID of a shipper you would like to delete");
        int deleteId = scanner.nextInt();

        // Run the delete
        dataManager.deleteShipper(deleteId);

        // Display all once more
        shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);
    }


}
