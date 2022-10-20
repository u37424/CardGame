package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Suit;
import de.cardgame.Value;

import java.util.LinkedList;

public class Health extends Zone<Card> {
    private LinkedList<Card> healthCards;
    private LinkedList<Card> lostCards;

    public Health() {
        super("Health");
        setup();
    }

    public Health(int limit) {
        super("Health", limit);
        setup();
    }

    @Override
    void setup() {
        this.healthCards = new LinkedList<>();
        this.lostCards = new LinkedList<>();
        for (int i = 0; i <= 41; i++) {
            healthCards.add(new Card(Suit.HEALTH, null));
        }
    }

    public Card getHealthCard() {
        return healthCards.getFirst();
    }

    public Card getLostCard() {
        return lostCards.getLast();
    }

    public void lose(int amount) {
        for (int i = 0; i < amount; i++) {
            if (healthCards.size() < 0) {
                healthCards.removeFirst();
                lostCards.add(new Card(Suit.LOST_HEALTH, null));
            } else {
                System.out.println("Dead?");
            }
        }
        updateImg();
    }

    public void get(int amount) {
        for (int i = 0; i < amount; i++) {
            if (lostCards.size() < 0) {
                lostCards.removeFirst();
                healthCards.add(new Card(Suit.HEALTH, null));
            } else {
                System.out.println("Full");
            }
        }
        updateImg();
    }

    void updateImg() {
        this.healthCards.getFirst().setImg();
        this.lostCards.getLast().setImg();
        System.out.println("Health "+healthCards.size());
    }

    public LinkedList<Card> getHealthCards() {
        return healthCards;
    }

    public LinkedList<Card> getLostCards() {
        return lostCards;
    }

    public boolean hasHealth() {
        if(healthCards.size() > 0) return true;
        return false;
    }

    public boolean hasLost(){
        if(lostCards.size() > 0) return true;
        return false;
    }
}
