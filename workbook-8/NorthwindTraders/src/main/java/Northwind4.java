import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Northwind4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String customerQuery = "SELECT * FROM customers ORDER BY country";
        String productQuery = "SELECT * FROM products ORDER BY productid";
        String categoryQuery = "SELECT categoryid, categoryname FROM categories ORDER BY categoryid";

        Scanner scanner = new Scanner(System.in);
        int choice=1;

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root","password");)
        {
            while (choice!=0){
                System.out.println("""
                    1) Display all products
                    2) Display all customers
                    3) Display all categories
                    0) Exit""");

                try {
                    choice = scanner.nextInt();

                    if (choice==1){
                        try (   PreparedStatement preparedStatement = connection.prepareStatement(productQuery);
                                ResultSet resultSet = preparedStatement.executeQuery();
                                ){
                            displayProducts(resultSet);
                        }
                    } else if (choice==2){
                        try (PreparedStatement preparedStatement = connection.prepareStatement(customerQuery);
                             ResultSet resultSet = preparedStatement.executeQuery();){
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
                        }
                    } else if (choice==3) {
                        try(PreparedStatement preparedStatement = connection.prepareStatement(categoryQuery);
                            ResultSet resultSet = preparedStatement.executeQuery();) {
                            while (resultSet.next()) {
                                System.out.printf("""
                                        Category ID:\t%d
                                        Name:\t%s
                                        --------------------
                                        """, resultSet.getInt(1), resultSet.getString(2));
                            }
                        }

                        System.out.println("Select a Category ID to display all products of that category");
                        int categoryId = scanner.nextInt();

                        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE categoryid = ?");){
                            preparedStatement.setInt(1, categoryId);
                            try(ResultSet resultSet = preparedStatement.executeQuery();){
                                displayProducts(resultSet);
                            }
                        }


                    }
                } catch (InputMismatchException e){
                    System.out.println("ERROR : input mismatch");
                    scanner.nextLine();
                    continue;
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void displayProducts(ResultSet resultSet){
        // Loop through the results
        try{
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
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
