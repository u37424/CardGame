package de.cardgame.Zones;

import de.cardgame.Card;

public class Dungeon extends Zone<Card>{
    public Dungeon() {
        super("Dungeon");
        setup();
    }

    public Dungeon(int limit) {
        super("Dungeon", limit);
        setup();
    }

    @Override
    void setup() {

    }
}
