import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Northwind3 {
    // Initialize the Connection, PreparedStatement and ResultSet variables as null
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                // Create the Connection and run the homeScreen
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root","password"); // Change if needed
                homeScreen();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally { // Close all resources
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static void homeScreen() {
        System.out.println("""
                        What would you like to do?
                            1) Display all products
                            2) Display all customers
                            0) Exit""");
        int choice = 0;
        try {
            choice = scanner.nextInt();

            if (choice==1){
                getProducts(connection);
                homeScreen();
            } else if (choice==2) {
                getCustomers(connection);
                homeScreen();
            } else if (choice==0) {
                // Does nothing. Lets the program end and the .close(s) happen
            } else {
                System.out.println("ERROR : input out of range");
                scanner.nextLine();
                homeScreen();
            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR : incorrect input");
            scanner.nextLine();
            homeScreen();
        }
    }

    public static void getCustomers(Connection connection){
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customers ORDER BY country");
            resultSet = preparedStatement.executeQuery();

            // Loop through the results
            while (resultSet.next()) {
                System.out.printf("""
                        Contact Name:\t%s
                        Company Name:\t%s
                        City:\t%s
                        Country:\t%s
                        Phone Number:\t%s
                        -----------------------------------
                        """, resultSet.getString("contactname"),resultSet.getString("companyname"),
                        resultSet.getString("city"), resultSet.getString("country"),resultSet.getString("phone"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getProducts(Connection connection){
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products");
            resultSet = preparedStatement.executeQuery();

            // Loop through the results
            while (resultSet.next()) {
                System.out.printf("""
                    Product ID: %d
                    Name:\t%s
                    Price:\t$%.2f
                    Stock:\t%d
                    ----------------------------
                    """,resultSet.getInt("productid"),resultSet.getString("productname"),
                        resultSet.getDouble("unitprice"),resultSet.getInt("unitsinstock"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
