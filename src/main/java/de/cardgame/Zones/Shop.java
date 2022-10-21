package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;

public class Shop extends Zone<Card> {
    public Shop() {
        super("Shop");
    }

    public Shop(int limit) {
        super("Shop", limit);
    }

    public static boolean putCardToShop() {
        if (Table.getDungeon().getSize() > 0) {
            if (Table.getShop().add(Table.getDungeon().getLast())) Table.getDungeon().removeLast();
            return true;
        }
        return false;
    }

    @Override
    void setup() {

    }
}
