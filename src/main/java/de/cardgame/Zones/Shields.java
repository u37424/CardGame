package de.cardgame.Zones;

import de.cardgame.Card;

public class Shields extends Zone<Card>{
    public Shields() {
        super("Shields");
    }

    public Shields( int limit) {
        super("Shields", limit);
    }

    @Override
    void setup() {

    }
}
