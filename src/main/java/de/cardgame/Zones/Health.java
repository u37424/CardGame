package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Game;
import de.cardgame.Suit;
import de.cardgame.Table;

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
        for (int i = 0; i < 52; i++) {
            Card c = new Card(Suit.HEALTH, null);
            c.setHealthValue(i+1);
            healthCards.add(c);
        }
    }

    public static void lose() {
        Health h = Table.getHealth();
        int value = Table.getActiveRoom().getLast().getVALUE().getValue();
        int amount = calcTemporaryHitAmount(value);
        for (int i = 0; i < amount; i++) {
            if (h.healthCards.size() > 0) {
                int temp = h.healthCards.getLast().getHealthValue();
                h.healthCards.removeLast();
                Card c = new Card(Suit.HEALTH_LOST, null);
                c.setHealthValue(temp);
                h.lostCards.add(c);
            } else {
                Game.end();
            }
        }
        h.updateImg();
    }

    public static void gain() {
        Health h = Table.getHealth();
        int amount = Table.getActiveRoom().getLast().getVALUE().getValue();
        for (int i = 0; i < amount; i++) {
            if (h.lostCards.size() > 0) {
                int temp = h.lostCards.getLast().getHealthValue();
                h.lostCards.removeLast();
                Card c = new Card(Suit.HEALTH_LOST, null);
                c.setHealthValue(temp);
                h.healthCards.add(c);
            }
        }
        h.updateImg();
    }

    private static int calcTemporaryHitAmount(int amount) {
        int tempHitPoints = 0;
        for (int i = amount - 2; i > 0; i -= 2) {
            tempHitPoints += i;
        }
        return tempHitPoints;
    }

    public Card getHealthCard() {
        return healthCards.getLast();
    }

    public Card getLostCard() {
        return lostCards.getLast();
    }

    void updateImg() {
        if (this.healthCards.size() > 0) this.healthCards.getLast().setImg();
        if (this.lostCards.size() > 0) this.lostCards.getLast().setImg();
        System.out.println("Health " + healthCards.size());
    }

    public LinkedList<Card> getHealthCards() {
        return healthCards;
    }

    public LinkedList<Card> getLostCards() {
        return lostCards;
    }

    public boolean hasHealth() {
        if (healthCards.size() > 0) return true;
        return false;
    }

    public boolean hasLost() {
        if (lostCards.size() > 0) return true;
        return false;
    }
}
