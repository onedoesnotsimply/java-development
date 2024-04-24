import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatDates {

    public static void main(String[] args) {
        // Create formatters
        DateTimeFormatter backSlashFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter fullMonthFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter dayMonTimeFormatter = DateTimeFormatter.ofPattern("E, MMM d, yyyy  hh:mm");

        // Create dates
        LocalDate todayDate = LocalDate.now();
        LocalDateTime todayDateTime = LocalDateTime.now();

        // Print out formatted dates
        System.out.println(todayDate.format(backSlashFormatter)+"\n"+todayDate);
        System.out.println(todayDate.format(fullMonthFormatter));

        String formattedDate = dayMonTimeFormatter.format(todayDateTime.atZone(ZoneId.of("GMT")));
        System.out.println(formattedDate);
    }
}
