package blackjack;

import java.util.*;

public class Game {

private Card[] Deck = new Card[52];
private ArrayList<Card> playerHand = new ArrayList<>();
private ArrayList<Card> dealerHand = new ArrayList<>();
private int pValue = 0;
private int dValue = 0;
private int cardCounter = 0;
private boolean endGame = false; 


public boolean isEndGame() {
    return endGame;
}

public int getCardCounter() {
    return cardCounter;
}

public void setCardCounter(int cardCounter) {
    this.cardCounter = cardCounter;
}

public int getpValue() {
    return pValue;
}

public int getdValue() {
    return dValue;
}

public ArrayList<Card> getPlayerHand() {
    return playerHand;
}

public ArrayList<Card> getDealerHand() {
    return dealerHand;
}

public void dealOneCardPlayer(int i) {
       playerHand.add(Deck[i]);
}

public void dealoneCardDealer(int i) {
       dealerHand.add(Deck[i]);
}

public void setDealerHand(ArrayList<Card> dealerHand) {
    this.dealerHand = dealerHand;
}

public void setDeck(Card[] Deck) {
    this.Deck = Deck;
}


public void displayPlayer(){       
    pValue = 0;
    dValue = 0;
    System.out.println("---------------------------------------------");
    System.out.println("DEALER HAND");
    for( int i = 0 ; i < dealerHand.size() ; i++){
    System.out.println(dealerHand.get(i).getName() + " of " +   dealerHand.get(i).getSuit());
    dValue = dValue + dealerHand.get(i).getValue();
    }
    System.out.println("Dealer Hand Value = " + dValue);

    System.out.println("---------------------------------------------");
    System.out.println("PLAYER HAND");
    for( int i = 0 ; i < playerHand.size() ; i++){
    System.out.println(playerHand.get(i).getName() + " of " + playerHand.get(i).getSuit());
    pValue = pValue + playerHand.get(i).getValue();
    }
    System.out.println("Player Hand Value = " + pValue);
    System.out.println("");
    System.out.println("");
}    


public void turnLoop() {

     Scanner keyboard = new Scanner(System.in);
     System.out.println("Do you want to (H)it, (S)tay, or (C)all?");
     String hitstaycall = keyboard.nextLine();
     if("h".equals(hitstaycall.toLowerCase())){
            playerHand.add(Deck[cardCounter]);
            pValue = pValue + Deck[cardCounter].getValue();
            cardCounter++;
            if ( dValue < 16 ){
                dealerHand.add(Deck[cardCounter]);
                dValue = dValue + Deck[cardCounter].getValue();
                cardCounter++;
            }

            dValue = 0;
            pValue = 0;

            for( int i = 0 ; i < dealerHand.size() ; i++){
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for( int i = 0 ; i < playerHand.size() ; i++){
                pValue = pValue + playerHand.get(i).getValue();
            }                

            if ( dValue > 21 && pValue > 21){
                System.out.println("You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21 ){
                System.out.println("BLACKJACK!");
                endGame = true;
            }
            if ( dValue > 21 && pValue < 22){
                System.out.println("Dealer BUST. You Win");
                endGame = true;
            }
            if ( pValue > 21 && dValue <22){
                System.out.println("You BUST. Dealer Win");
                endGame = true;
            }


        }
        else if("s".equals(hitstaycall.toLowerCase())){                
            if ( dValue < 16 ){
                dealerHand.add(Deck[cardCounter]);
                dValue = dValue + Deck[cardCounter].getValue();
                cardCounter++;
            }
               dValue = 0;
            pValue = 0;

            for( int i = 0 ; i < dealerHand.size() ; i++){
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for( int i = 0 ; i < playerHand.size() ; i++){
                pValue = pValue + playerHand.get(i).getValue();
            }                

            if ( dValue > 21 && pValue > 21){
                System.out.println("You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21 ){
                System.out.println("BLACKJACK!");
                endGame = true;
            }
            if ( dValue > 21 && pValue < 22){
                System.out.println("Dealer BUST. You Win");
                endGame = true;
            }
            if ( pValue > 21 && dValue <22){
                System.out.println("You BUST. Dealer Win");
                endGame = true;
            }
        }
        else if("c".equals(hitstaycall.toLowerCase())){               
            dValue = 0;
            pValue = 0;

            for( int i = 0 ; i < dealerHand.size() ; i++){
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for( int i = 0 ; i < playerHand.size() ; i++){
                pValue = pValue + playerHand.get(i).getValue();
            }

            if ( dValue < pValue && pValue < 21){
                dealerHand.add(Deck[cardCounter]);
                dValue = dValue + Deck[cardCounter].getValue();
                cardCounter++;
            }
            if ( pValue > dValue && pValue < 22){
            System.out.print("YOU WIN!!!!");
            endGame = true;
            }
            if ( dValue > pValue && dValue < 22){
                System.out.println("Dealer Wins!");
                endGame = true;
            }
            if ( dValue > 21 && pValue > 21){
                System.out.println("You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21 ){
                System.out.println("BLACKJACK!");
                endGame = true;
            }
            if ( dValue > 21 && pValue < 22){
                System.out.println("Dealer BUST. You Win");
                endGame = true;
            }
            if ( pValue > 21 && dValue <22){
                System.out.println("You BUST. Dealer Win");
                endGame = true;
            }
            }

        else { System.out.println("Hey you.");
}
}


public void check(){
            dValue = 0;
            pValue = 0;

            for( int i = 0 ; i < dealerHand.size() ; i++){
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for( int i = 0 ; i < playerHand.size() ; i++){
                pValue = pValue + playerHand.get(i).getValue();
            }                



            if ( dValue > 21 && pValue > 21){
                System.out.println("You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21 ){
                System.out.println("BLACKJACK!");
                endGame = true;
            }
            if ( dValue > 21 && pValue < 22){
                System.out.println("Dealer BUST. You Win");
                endGame = true;
            }
            if ( pValue > 21 && dValue <22){
                System.out.println("You BUST. Dealer Win");
                endGame = true;
            }
}
}