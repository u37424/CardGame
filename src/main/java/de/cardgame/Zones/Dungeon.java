package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;

public class Dungeon extends Zone<Card> {
    public Dungeon() {
        super("Dungeon");
        setup();
    }

    public Dungeon(int limit) {
        super("Dungeon", limit);
        setup();
    }

    public static boolean clickDungeon(Table table) {
        if (table.getDungeon().getSize() > 0) {
            table.getActiveRoom().add(table.getDungeon().getFirst());
            table.getActiveRoom().getLast().flip();
            table.getDungeon().removeFirst();
            ActiveRoom.putDown(table);
            return true;
        }
        return false;
    }

    public static boolean clickOpenLeft(Table table) {
        if (table.getLeftRoom() != null) {
            table.getActiveRoom().add(table.getLeftRoom());
            table.setLeftRoom(null);
            ActiveRoom.putDown(table);
            if(table.getDungeon().getSize() > 0) {
                table.setLeftRoom(table.getDungeon().getFirst());
                table.getLeftRoom().flip();
                table.getDungeon().removeFirst();
            }
            return true;
        }
        return false;
    }

    public static boolean clickOpenRight(Table table) {
        if (table.getRightRoom() != null) {
            table.getActiveRoom().add(table.getRightRoom());
            table.setRightRoom(null);
            ActiveRoom.putDown(table);
            if(table.getDungeon().getSize() > 0) {
                table.setRightRoom(table.getDungeon().getFirst());
                table.getRightRoom().flip();
                table.getDungeon().removeFirst();
            }
            return true;
        }
        return false;
    }

    @Override
    void setup() {

    }
}
