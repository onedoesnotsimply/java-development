package com.pluralsight;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SakilaDataManager {
    private DataSource dataSource;

    public SakilaDataManager(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Actor> getAllActors(){
        List<Actor> actors = new ArrayList<>();

        String query = "SELECT actor_id, first_name, last_name FROM actor";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();){

            while (resultSet.next()){
                int id = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Actor actor = new Actor(id, firstName, lastName);
                actors.add(actor);
            }
            return actors;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Actor> getActorByName(String firstName, String lastName) {
        List<Actor> actors = new ArrayList<>();

        String query = "SELECT actor_id, first_name, last_name FROM actor WHERE first_name LIKE ? AND last_name LIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            try(ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()){
                    int id = resultSet.getInt("actor_id");
                    String firstName1 = resultSet.getString("first_name");
                    String lastName1 = resultSet.getString("last_name");

                    Actor actor = new Actor(id, firstName1, lastName1);
                    actors.add(actor);
                }
            }
            return actors;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Film> searchForMovies(int actorId) {
        List<Film> films = new ArrayList<>();

        // Create the connection and the prepared statement
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT film.film_id, title, description, release_year,length FROM film " +
                     "JOIN film_actor ON (film.film_id = film_actor.film_id) " +
                     "JOIN actor ON (film_actor.actor_id = actor.actor_id) " +
                     "WHERE actor.actor_id = ?");){

            // Set the prepared statement parameters
            preparedStatement.setInt(1, actorId);

            // Execute the query
            try(ResultSet resultSet = preparedStatement.executeQuery();){
                // Make sure that there are results
                if (resultSet.next()) {
                    do {
                        // Process results
                        int id = resultSet.getInt("film_id");
                        String title = resultSet.getString("title");
                        String description = resultSet.getString("description");
                        int releaseYear = resultSet.getInt("release_year");
                        int length = resultSet.getInt("length");

                        Film film = new Film(id,title,description,releaseYear,length);
                        films.add(film);

                    } while (resultSet.next());
                } else {
                    System.out.println("No movies found");
                }
            }
            return films;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
