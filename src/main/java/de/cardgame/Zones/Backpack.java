package de.cardgame.Zones;

import de.cardgame.Card;

public class Backpack extends Zone<Card>{
    public Backpack() {
        super("Backpack");
    }

    public Backpack(int limit) {
        super("Backpack", limit);
    }

    @Override
    void setup() {

    }
}
