package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Suit;
import de.cardgame.Table;
import de.cardgame.Window.Window;

public class Souls extends Zone<Card> {
    public Souls() {
        super("Souls");
    }

    public Souls(int limit) {
        super("Souls", limit);
    }

    public static void takeNew() {
        if (Table.getSouls().add(Table.getActiveRoom().getLast())) Table.getActiveRoom().removeLast();
        Table.getSouls().getLast().changeSUIT(Suit.SOULS);
    }

    public static boolean heal(int soulsIndex) {
        if(soulsIndex < 0 || soulsIndex > Table.getSouls().getSize()) return false;
        if(Table.getTrash().add(Table.getSouls().getIndex(soulsIndex))) Table.getSouls().removeIndex(soulsIndex);
        Window.getPos().setSOULS_OFFSET();
        return true;
    }

    @Override
    void setup() {

    }
}
