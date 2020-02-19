package blackjack;

import java.util.*;

public class BlackJack {

public static void main(String[] args) {
    boolean play = true;

    while (play == true) {
        Game game1 = new Game();
        Scanner keyboard = new Scanner(System.in);
        Deck deck1 = new Deck();
        deck1.createDeck();
        deck1.shuffleDeck(deck1.getDeck1());
        game1.setDeck(deck1.getDeck2());
        System.out.println("Welcome to BLACKJACK!");
        System.out.println("------------------------");
        System.out.println("Enter 1 to Start: ");
        int start = keyboard.nextInt();

        if (start == 1) {
            deck1.createDeck();
            System.out.println("Shuffling Deck");
            deck1.shuffleDeck(deck1.getDeck1());
            System.out.println("Shuffling Deck");
            System.out.println("Shuffling Deck");
            System.out.println("Shuffling Deck");
            System.out.println("Shuffling Deck");
            System.out.println("Shuffling Deck");

            System.out.println("Lets Play!");

            game1.dealOneCardPlayer(game1.getCardCounter());
            game1.setCardCounter(game1.getCardCounter() + 1);
            game1.dealOneCardPlayer(game1.getCardCounter());
            game1.setCardCounter(game1.getCardCounter() + 1);
            game1.dealoneCardDealer(game1.getCardCounter());
            game1.setCardCounter(game1.getCardCounter() + 1);
            game1.dealoneCardDealer(game1.getCardCounter());
            game1.setCardCounter(game1.getCardCounter() + 1);
            game1.check();
        }

        while (game1.isEndGame() == false) {
            game1.displayPlayer();
            game1.turnLoop();

        }
        if (game1.isEndGame() == true) {
            System.out.println("FINAL HANDS");
            System.out.println("");
            game1.displayPlayer();
            System.out.println("");
            System.out.println("Do you want to Play again? 1 = yes or 2 = no");
            int answer = keyboard.nextInt();
            if (answer == 1) {
                play = true;
            } else if (answer == 2) {
                System.out.println("Fine, Go do something else.");
                play = false;
            }

        } else {
            System.out.println("Why won't you play with me billy?");
        }

    }

}
}