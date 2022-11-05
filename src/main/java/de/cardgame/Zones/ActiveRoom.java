package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Fight;
import de.cardgame.Suit;
import de.cardgame.Table;

public class ActiveRoom extends Zone<Card>{
    public ActiveRoom() {
        super("ActiveRoom");
    }

    public ActiveRoom(int limit) {
        super("ActiveRoom", limit);
    }

    public static void putDown() {
        if(Table.getActiveRoom().getSize() > 0 && Table.getActiveRoom().getLast().getSUIT().equals(Suit.CLUBS)) Shop.putCardToShop();
        if(Table.getActiveRoom().getSize() > 0 && Table.getActiveRoom().getLast().getSUIT().equals(Suit.HEARTS)) Fight.engage();
        if(Table.getActiveRoom().getSize() > 0 && Table.getActiveRoom().getLast().getSUIT().equals(Suit.DIAMONDS)) Gold.takeNew();
    }

    @Override
    void setup() {

    }
}
