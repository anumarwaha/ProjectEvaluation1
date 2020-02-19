package blackjack;
import java.util.*;

public class Deck {

private Card[] Deck1 = new Card[52];
private Card[] Deck2 = new Card[52];

public Card[] getDeck2() {
    return Deck2;
}


// this is important... I think.
public void setDeck2(Card[] Deck2) {
    this.Deck2 = Deck2;
}






public Card[] getDeck1() {
    return Deck1;
}

public void setDeck1(Card[] Deck1) {
    this.Deck1 = Deck1;
}



public Card getOneCard2(int i) {
    System.out.println("your drew the " + Deck2[i].getName() + " of " + Deck2[i].getSuit());
    return Deck1[2];
}



public Card getOneCard(int i) {
    System.out.println("your drew the " + Deck1[i].getName() + " of " + Deck1[i].getSuit());
    return Deck1[i];
}

 public void setDeck(Card Card, int position) {
    Deck1[position] = Card;
}



public void shuffleDeck(Card[] Deck){        
    for(int i = 0; i < 52 ; i++){
    Random rand = new Random();
    int position = rand.nextInt((51 - 0) + 1);        
    Deck2[i] = Deck1[position];
    }
} 
public void printDeck1(){
    for(int i = 0; i < 52 ; i++){
        System.out.println(Deck1[i].getName() + " of " + Deck1[i].getSuit() + " In Game Value: " + Deck1[i].getValue() );
    }
}


 public void createDeck(){
     int B;
     int value;
     String suit;
     int deckPosition = 0;
     for( B = 1 ; B <= 4 ; B++){
         if( B == 1){
             suit = "Spades";
         }
         else if (B == 2){
             suit = "Hearts";
         }
         else if (B == 3){
             suit = "Clubs";
         }
         else {
             suit = "Diamonds";
         }    
         for (int i = 1; i <= 13; i++){
             value = i;
             Card card = new Card(value, suit);
             Deck1[deckPosition] = card;
             if(Deck1[deckPosition].getValue() == 11){
                 Deck1[deckPosition].setName("Jack");
                  Deck1[deckPosition].setValue(10);
             }
             else if(Deck1[deckPosition].getValue() == 12){
                 Deck1[deckPosition].setName("Queen");
                 Deck1[deckPosition].setValue(10);
             }
             else if(Deck1[deckPosition].getValue() == 13){
                 Deck1[deckPosition].setName("King");
                 Deck1[deckPosition].setValue(10);
             }
             else if(Deck1[deckPosition].getValue() == 1){
                 Deck1[deckPosition].setName("Ace");
                 Deck1[deckPosition].setValue(11);

             }
             else{
                 Deck1[deckPosition].setName(Integer.toString(Deck1[deckPosition].getValue()));
             }
             deckPosition++;
        }
     }

 }

 }