package de.cardgame.Zones;

import de.cardgame.Card;
import de.cardgame.Table;
import de.cardgame.Window.FieldPositions;

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

    public static boolean pay(int goldIndex) {
        if(goldIndex < 0 || goldIndex > Table.getGold().getSize()) return false;
        if(Table.getTrash().add(Table.getGold().getIndex(goldIndex))) Table.getGold().removeIndex(goldIndex);
        System.out.println("P: "+Table.getTrash().getLast().getVALUE());
        FieldPositions.setGoldOffset();
        return true;
    }

    @Override
    void setup() {

    }
}
