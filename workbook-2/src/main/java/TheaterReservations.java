import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Prompt for name
        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine();
        String[] splitName = fullName.split(" ");

        // Prompt for date of reservation
        System.out.print("What date will you be coming? (MM/dd/yyyy): ");
        String dateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        // Prompt for number of tickets
        System.out.print("How many tickets would you like? ");
        int numberOfTickets = scanner.nextInt();

        if (numberOfTickets > 1){
            System.out.println(numberOfTickets+" tickets reserved for "+date+" under "+splitName[1]+", "+splitName[0]);
        } else if (numberOfTickets==1){
            System.out.println("1 ticket reserved for "+date+" under "+splitName[1]+", "+splitName[0]);
        } else {
            System.out.println("Invalid ticket number.");
        }
    }
}
