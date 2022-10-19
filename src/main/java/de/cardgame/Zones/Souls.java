package de.cardgame.Zones;

import de.cardgame.Card;

public class Souls extends Zone<Card>{
    public Souls() {
        super("Souls");
    }

    public Souls(int limit) {
        super("Souls", limit);
    }

    @Override
    void setup() {

    }
}
