import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Sakila1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create datasource
        BasicDataSource dataSource = new BasicDataSource();

        // Configure the datasource
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        // Prompt user for the lastname of an actor
        searchByLastName(dataSource);

        // Search for all movies with a particular actor in it
        searchForMovies(dataSource);
    }

    public static void searchByLastName(DataSource dataSource){
        // Prompt user for the last name of an actor
        System.out.println("Enter the last name of an actor :");

        // Save the last name
        String last_name = scanner.nextLine();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT first_name, last_name FROM actor WHERE last_name LIKE ?");){

            // Set the prepared statement parameter
            preparedStatement.setString(1,last_name);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                // use the first call to next() to see if there are records
                if (resultSet.next()) {
                    System.out.printf("Actors with the last name %s:\n\n",last_name);
                        // if there are, you are already sitting on the first one so
                        // switch your loop to using a do/while
                    do {
                        // process results
                        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
                    } while (resultSet.next());
                }
                else {
                    System.out.println("No Matches Found");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchForMovies(DataSource dataSource) {
        // Prompt for first and last name of an actor
        System.out.println("Enter the first and last name of an actor");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("\nLast Name: ");
        String lastName = scanner.nextLine();

        // Create the connection and the prepared statement
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT title FROM film_text " +
                    "JOIN film_actor ON (film_text.film_id = film_actor.film_id) " +
                    "JOIN actor ON (film_actor.actor_id = actor.actor_id) WHERE first_name LIKE ? AND last_name LIKE ?");){

            // Set the prepared statement parameters
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            // Execute the query
            try(ResultSet resultSet = preparedStatement.executeQuery();){
                // Make sure that there are results
                if (resultSet.next()) {
                    System.out.printf("Movies with %s %s:\n\n",firstName,lastName);
                    do {
                        // Process results
                        System.out.println(resultSet.getString(1));
                    } while (resultSet.next());
                } else {
                    System.out.printf("No movies found for %s %s\n", firstName,lastName);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
