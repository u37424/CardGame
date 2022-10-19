package de.cardgame.Window;

import de.cardgame.Table;
import de.cardgame.Zones.Dungeon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseWindowHandler extends MouseAdapter {

    private final Table table;
    private Window window;

    public MouseWindowHandler(Table table, Window window) {
        this.table = table;
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
            if(Dungeon.clickDungeon(table)) window.repaint();
        } else if (isOnOpenLeft(x, y)) {
            if(Dungeon.clickOpenLeft(table)) window.repaint();
        } else if (isOnOpenRight(x, y)) {
            if(Dungeon.clickOpenRight(table)) window.repaint();
        }
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
