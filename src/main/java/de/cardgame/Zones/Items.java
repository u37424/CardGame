package de.cardgame.Zones;

import de.cardgame.Card;

public class Items extends Zone<Card>{
    public Items() {
        super("Items");
    }

    public Items( int limit) {
        super("Items", limit);
    }

    @Override
    void setup() {

    }
}
