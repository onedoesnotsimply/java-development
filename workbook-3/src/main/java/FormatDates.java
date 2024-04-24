import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatDates {

    public static void main(String[] args) {
        DateTimeFormatter backSlashFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate todayDate = LocalDate.now();
        LocalDateTime todayDateTime = LocalDateTime.now();
        DateTimeFormatter fullMonthFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter dayMonTimeFormatter = DateTimeFormatter.ofPattern("E, MMM d, yyyy  hh:mm");

        // These work
        System.out.println(todayDate.format(backSlashFormatter)+"\n"+todayDate);
        System.out.println(todayDate.format(fullMonthFormatter));
        System.out.println(todayDateTime.format(dayMonTimeFormatter));
    }
}
