package de.cardgame.Zones;

import de.cardgame.Card;

public class Trash extends Zone<Card>{
    public Trash() {
        super("Trash");
    }

    public Trash( int limit) {
        super("Trash", limit);
    }

    @Override
    void setup() {

    }
}
