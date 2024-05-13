import com.pluralsight.Card;
import com.pluralsight.Hand;
import com.pluralsight.Deck;

import java.util.Scanner;

public class BlackJack {
    // Static variables
    static Scanner scanner = new Scanner(System.in);
    static Hand hand1;
    static Hand hand2;
    static Deck deck;

    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack");

        // Set up the game
        setUp();

        // Reveal who got closer to 21
        System.out.printf("%s got %d\n", hand1.getName(),hand1.getValue());
        System.out.printf("%s got %d\n", hand2.getName(),hand2.getValue());


        if ((hand1.getValue()>hand2.getValue()) && (hand1.getValue() <= 21)) {
            System.out.printf("%s is the winner!", hand1.getName());
        } else if ((hand2.getValue()>hand1.getValue()) && (hand2.getValue() <= 21)) {
            System.out.printf("%s is the winner!", hand2.getName());
        }

    }

    public static void setUp() {
        // Prompt for names
        System.out.print("Enter the name of player 1 : ");
        String playerOneName = scanner.nextLine();
        System.out.print("Enter the name of player 2 : ");
        String playerTwoName = scanner.nextLine();

        // Create and shuffle the deck object
        deck = new Deck();
        deck.shuffle();

        hand1 = new Hand(playerOneName);
        hand2 = new Hand(playerTwoName);

        // Deal 2 cards to the users
        for (int i = 0; i < 2; i++) {
            Card card1 = deck.deal(); // Get a card from the deck
            hand1.deal(card1); // Deal it to hand1
            Card card2 = deck.deal(); // Get a second card from the deck
            hand2.deal(card2); // Deal it to hand2
        }

        // Reveal who got closer to 21
        // Prompt for hit or stand, call appropriate methods
    }
        // Create methods for bonuses
}
