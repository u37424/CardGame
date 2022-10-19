package de.cardgame.Window;

import de.cardgame.Table;

import java.awt.Window;
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
     * @param e Click des Users.
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
