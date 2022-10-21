package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;

public class Souls extends Zone<Card> {
    public Souls() {
        super("Souls");
    }

    public Souls(int limit) {
        super("Souls", limit);
    }

    public static void takeNew() {
        if (Table.getSouls().add(Table.getActiveRoom().getLast())) Table.getActiveRoom().removeLast();
    }

    @Override
    void setup() {

    }
}
