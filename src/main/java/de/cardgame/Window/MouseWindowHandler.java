package de.cardgame.Window;

import de.cardgame.Table;
import de.cardgame.Zones.Dungeon;
import de.cardgame.Zones.Gold;
import de.cardgame.Zones.Souls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseWindowHandler extends MouseAdapter {

    private Window window;

    public MouseWindowHandler(Window window) {
        this.window = window;
    }

    /**
     * Erkennt Klick-Events in der DrawArea.<br>
     * Erstellt Drawables in der zugeordneten DrawArea per Doppelklick oder loescht sie bei einem <br>
     * gewissen Threshold.
     *
     * @param e Click des Users.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (isOnDungeon(x, y)) {
            if (Dungeon.clickDungeon()) window.repaint();
        } else if (isOnOpenLeft(x, y)) {
            if (Dungeon.clickOpenLeft()) window.repaint();
        } else if (isOnOpenRight(x, y)) {
            if (Dungeon.clickOpenRight()) window.repaint();
        } else if (isOnSouls(x, y)) {
            if (Souls.heal(soulsIndex(x))) window.repaint();
        } else if (isOnGold(x, y)) {
            if (Gold.pay(goldIndex(x))) window.repaint();
        }
    }

    private boolean isOnGold(int x, int y) {
        if(Table.getGold().getSize() == 0) return false;
        FieldPositions p = window.getPos();
        return x >= p.getGoldX(0) && x <= (p.getGoldX(0) + window.getCardWidth() + FieldPositions.getGoldOffset()*(Table.getGold().getSize()-1))
                && y >= p.getGoldY(0) && y <= (p.getGoldY(0) + window.getCardHeight());
    }

    private int goldIndex(int x) {
        FieldPositions p = window.getPos();
        for (int i = 0; i < Table.getGold().getSize(); i++) {
            int width = FieldPositions.getGoldOffset();
            if(i == Table.getGold().getSize()-1) width = window.getCardWidth();
            if (x >= p.getSoulsX(i) && x <= (p.getSoulsX(i) + width)) return i;
        }
        return -1;
    }

    private int soulsIndex(int x) {
        FieldPositions p = window.getPos();
        for (int i = 0; i < Table.getSouls().getSize(); i++) {
            int width = FieldPositions.getSOULS_OFFSET();
            if(i == Table.getSouls().getSize()-1) width = window.getCardWidth();
            if (x >= p.getSoulsX(i) && x <= (p.getSoulsX(i) + width)) return i;
        }
        return -1;
    }

    private boolean isOnSouls(int x, int y) {
        if(Table.getSouls().getSize() == 0) return false;
        FieldPositions p = window.getPos();
        return x >= p.getSoulsX(0) && x <= (p.getSoulsX(0) + window.getCardWidth() + FieldPositions.getSOULS_OFFSET()*(Table.getSouls().getSize()-1))
                && y >= p.getSoulsY(0) && y <= (p.getSoulsY(0) + window.getCardHeight());
    }

    private boolean isOnOpenRight(int x, int y) {
        FieldPositions p = window.getPos();
        return x >= p.getRightRoomX() && x <= (p.getRightRoomX() + window.getCardWidth())
                && y >= p.getRightRoomY() && y <= (p.getRightRoomY() + window.getCardHeight());
    }

    private boolean isOnOpenLeft(int x, int y) {
        FieldPositions p = window.getPos();
        return x >= p.getLeftRoomX() && x <= (p.getLeftRoomX() + window.getCardWidth())
                && y >= p.getLeftRoomY() && y <= (p.getLeftRoomY() + window.getCardHeight());
    }

    private boolean isOnDungeon(int x, int y) {
        FieldPositions p = window.getPos();
        return x >= p.getDungeonX() && x <= (p.getDungeonX() + window.getCardWidth())
                && y >= p.getDungeonY() && y <= (p.getDungeonY() + window.getCardHeight());
    }
}
