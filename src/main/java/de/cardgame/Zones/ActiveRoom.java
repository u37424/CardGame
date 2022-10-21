package de.cardgame.Zones;

import de.cardgame.Card;
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
        if(Table.getActiveRoom().getLast().getSUIT().equals(Suit.CLUBS)) Shop.putCardToShop();
        if(Table.getActiveRoom().getLast().getSUIT().equals(Suit.HEARTS)) Health.lose();
    }

    @Override
    void setup() {

    }
}
