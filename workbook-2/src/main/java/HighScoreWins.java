import java.util.Scanner;

public class HighScoreWins {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Prompt for game score
        System.out.print("Please enter score in the following format (team1:team2|score1:score2) : ");
        String rawInput = scanner.nextLine();

        String[] firstSplit = rawInput.split("\\|");
        String[] teamNames = firstSplit[0].split(":");
        String[] teamScores = firstSplit[1].split(":");

        if (Integer.parseInt(teamScores[0])>Integer.parseInt(teamScores[1])){
            System.out.println("Winner: "+teamNames[0]);
        } else if (Integer.parseInt(teamScores[0])==Integer.parseInt(teamScores[1])) {
            System.out.println("Tie");
        } else {
            System.out.println("Winner: "+teamNames[1]);
        }

    }
}
