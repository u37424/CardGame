package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;

public class Gold extends Zone<Card>{

    public Gold() {
        super("Gold");
        setup();
    }

    public Gold(int limit) {
        super("Gold", limit);
        setup();
    }

    public static void takeNew() {
        if (Table.getGold().add(Table.getActiveRoom().getLast())) Table.getActiveRoom().removeLast();
    }

    @Override
    void setup() {

    }
}
