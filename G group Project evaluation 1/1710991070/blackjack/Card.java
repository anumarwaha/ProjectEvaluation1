package blackjack;
import java.util.*;

public class Card {
private int value;
private String suit;
private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Card(int value, String suit) {
    this.value = value;
    this.suit = suit;
}

public int getValue() {
    return value;
}

public void setValue(int value) {
    this.value = value;
}

public String getSuit() {
    return suit;
}

public void setSuit(String suit) {
    this.suit = suit;
}


}
