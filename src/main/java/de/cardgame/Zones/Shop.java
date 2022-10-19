package de.cardgame.Zones;

import de.cardgame.Card;

public class Shop extends Zone<Card>{
    public Shop() {
        super("Shop");
    }

    public Shop(int limit) {
        super("Shop", limit);
    }

    @Override
    void setup() {

    }
}
