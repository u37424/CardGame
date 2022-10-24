package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;
import de.cardgame.Window.FieldPositions;

import java.awt.*;

public class Souls extends Zone<Card> {
    public Souls() {
        super("Souls");
    }

    public Souls(int limit) {
        super("Souls", limit);
    }

    public static void takeNew() {
        if (Table.getSouls().add(Table.getActiveRoom().getLast())) Table.getActiveRoom().removeLast();
        System.out.println("Dist "+FieldPositions.getSOULS_OFFSET());
    }

    public static boolean heal(int soulsIndex) {
        if(soulsIndex < 0 || soulsIndex > Table.getSouls().getSize()) return false;
        if(Table.getTrash().add(Table.getSouls().getIndex(soulsIndex))) Table.getSouls().removeIndex(soulsIndex);
        FieldPositions.setSOULS_OFFSET();
        return true;
    }

    @Override
    void setup() {

    }
}
