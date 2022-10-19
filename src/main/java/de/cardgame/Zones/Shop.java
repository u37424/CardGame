package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;

public class Shop extends Zone<Card>{
    public Shop() {
        super("Shop");
    }

    public Shop(int limit) {
        super("Shop", limit);
    }

    public static boolean putCardToShop(Table table) {
        if(table.getDungeon().getSize() >0) {
            table.getShop().add(table.getDungeon().getFirst());
            table.getDungeon().removeFirst();
            return true;
        }
        return false;
    }

    @Override
    void setup() {

    }
}
