import java.util.Scanner;

import com.pluralsight.FullNameApplication;

public class FullNameGenerator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String username = FullNameApplication.namePrompt();
        System.out.println(username);
    }


}


