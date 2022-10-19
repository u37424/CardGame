package de.cardgame.Zones;

import de.cardgame.Card;

public class Gold extends Zone<Card>{

    public Gold() {
        super("Gold");
        setup();
    }

    public Gold(int limit) {
        super("Gold", limit);
        setup();
    }

    @Override
    void setup() {

    }
}
