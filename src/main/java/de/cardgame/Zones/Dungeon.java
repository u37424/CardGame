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

    public static boolean clickDungeon() {
        if (Table.getDungeon().getSize() > 0) {
            if (Table.getActiveRoom().add(Table.getDungeon().getLast())) Table.getDungeon().removeLast();
            Table.getActiveRoom().getLast().flip();
            ActiveRoom.putDown();
            return true;
        }
        return false;
    }

    public static boolean clickOpenLeft() {
        if (Table.getLeftRoom() != null) {
            if (Table.getActiveRoom().add(Table.getLeftRoom())) Table.setLeftRoom(null);
            if (Table.getDungeon().getSize() > 0) {
                Table.setLeftRoom(Table.getDungeon().getLast());
                Table.getLeftRoom().flip();
                Table.getDungeon().removeLast();
            }
            ActiveRoom.putDown();
            return true;
        }
        return false;
    }

    public static boolean clickOpenRight() {
        if (Table.getRightRoom() != null) {
            if (Table.getActiveRoom().add(Table.getRightRoom())) Table.setRightRoom(null);
            if (Table.getDungeon().getSize() > 0) {
                Table.setRightRoom(Table.getDungeon().getLast());
                Table.getRightRoom().flip();
                Table.getDungeon().removeLast();
            }
            ActiveRoom.putDown();
            return true;
        }
        return false;
    }

    @Override
    void setup() {

    }
}
