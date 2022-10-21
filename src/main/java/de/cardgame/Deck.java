package de.cardgame;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private static final int DECK_SIZE = 52;
    private final LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();

        //Erschafft neues Deck und mischt es durch
        createDeck();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    private void createDeck() {
        int val = 2;
        int suit = 1;
        while (cards.size() < DECK_SIZE) {
            Card newCard = new Card(getSuit(suit), getValue(val++));
            cards.add(newCard);
            if (val == 15) {
                val = 2;
                suit++;
            }
        }
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    private Value getValue(int val) {
        if (val == 2) return Value.TWO;
        if (val == 3) return Value.THREE;
        if (val == 4) return Value.FOUR;
        if (val == 5) return Value.FIVE;
        if (val == 6) return Value.SIX;
        if (val == 7) return Value.SEVEN;
        if (val == 8) return Value.EIGHT;
        if (val == 9) return Value.NINE;
        if (val == 10) return Value.TEN;
        if (val == 11) return Value.JACK;
        if (val == 12) return Value.QUEEN;
        if (val == 13) return Value.KING;
        if (val == 14) return Value.ACE;
        else return null;
    }

    private Suit getSuit(int val) {
        if (val == 1) return Suit.HEARTS;
        if (val == 2) return Suit.DIAMONDS;
        if (val == 3) return Suit.SPADES;
        if (val == 4) return Suit.CLUBS;
        else return null;
    }

    public static int getDeckSize() {
        return DECK_SIZE;
    }
}
