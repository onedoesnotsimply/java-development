import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        // Create a scanner for prompting
        Scanner scanner = new Scanner(System.in);
        logAction("launch");

        do {
            // Prompt user action
            System.out.println("Enter a search term (X to exit): ");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("x")){
                return;
            } else {
                logAction("search : "+item);
            }

        } while (true);
    }

    public static void logAction(String action){
        try {
            // Create file/buffered writer
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logs.txt", true));
            bufferedWriter.write(getCurrentDateTime()+" "+action+"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCurrentDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(ldt);
    }

}
