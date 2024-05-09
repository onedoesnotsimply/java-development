import com.pluralsight.Card;
import com.pluralsight.Hand;
import com.pluralsight.Deck;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to BlackJack");

        // Prompt for names
        System.out.print("Enter the name of player 1 : ");
        String playerOneName = scanner.nextLine();
        System.out.print("Enter the name of player 2 : ");
        String playerTwoName = scanner.nextLine();

        // Create and shuffle the deck object
        Deck deck = new Deck();
        deck.shuffle();

        Hand hand1 = new Hand(playerOneName);
        Hand hand2 = new Hand(playerTwoName);

        // Deal 2 cards to the users
        for (int i = 0; i < 2; i++) {
            Card card1 = deck.deal(); // Get a card from the deck
            hand1.deal(card1); // Deal it to hand1
            Card card2 = deck.deal(); // Get a second card from the deck
            hand2.deal(card2); // Deal it to hand2
        }

        // Record the score values
        int handOneValue = hand1.getValue();
        int handTwoValue = hand2.getValue();

        // Reveal who got closer to 21
        System.out.printf("%s got %d\n", hand1.getName(),handOneValue);
        System.out.printf("%s got %d\n", hand2.getName(),handTwoValue);

        if (handOneValue>handTwoValue) {
            System.out.printf("%s is the winner!", hand1.getName());
        } else {
            System.out.printf("%s is the winner!", hand2.getName());
        }

    }
}
