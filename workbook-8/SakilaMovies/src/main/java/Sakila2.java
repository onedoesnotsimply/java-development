import com.pluralsight.Actor;
import com.pluralsight.Film;
import com.pluralsight.SakilaDataManager;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Sakila2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        // Create datamanager
        SakilaDataManager dataManager = new SakilaDataManager(dataSource);

        // Prompt for an actor's first and last name
        System.out.println("Search for an actor");
        System.out.print("Enter actors first name : ");
        String firstName = scanner.nextLine();
        System.out.print("Enter actors last name : ");
        String lastName = scanner.nextLine();

        List<Actor> actors = dataManager.getActorByName(firstName,lastName);

        actors.forEach(System.out::println);

        // Prompt for an actor id
        System.out.print("Enter the ID of an actor : ");
        int actorId = scanner.nextInt();

        List<Film> films = dataManager.searchForMovies(actorId);

        films.forEach(System.out::println);

    }
}
