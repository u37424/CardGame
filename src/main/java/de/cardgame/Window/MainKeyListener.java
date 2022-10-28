package de.cardgame.Window;

import de.cardgame.Dice;
import de.cardgame.Table;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainKeyListener implements KeyListener {

    private Window window;

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F11) {
            if (window.getState() == Frame.NORMAL) {
                window.setState(Frame.ICONIFIED);
            } else {
                window.setState(Frame.NORMAL);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_F12) {
            window.dispose();
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            Random r = new Random();
            if(!Table.getCarrySpace().grow(r.nextInt(1,4))) System.out.println("No more Dice in Dice Pool!");
            window.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_O) {
            Random r = new Random();
            int rand = r.nextInt(2,14);
            Table.getCarrySpace().shrink(rand);
            window.repaint();
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setWindow(Window window) {
        this.window = window;
    }
}
