package de.cardgame;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Window extends JFrame {

    private final int FRAME_SIZE_X = 1920;
    private final int FRAME_SIZE_Y = 1080;
    private static final Color BACKGROUND = Color.BLACK;
    private static final int CARD_WIDTH = 80+10;
    private static final int CARD_HEIGHT = 110+20;
    private MouseWindowHandler mouse;
    private MainKeyListener keys;
    private final Table playground;

    public Window(Table table) {
        setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
        setResizable(true);
        setTitle("LEGEND v.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(Color.BLACK);
        this.setVisible(true);
        setBackground(BACKGROUND);
        this.playground = table;
    }

    /**
     * Zeichnet die Inhalte der Zeichenebene inklusive aller vorhandenen Drawables.
     *
     * @param g Grafik
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawAll(g2d);
    }

    private void drawAll(Graphics2D g2d) {
        int x = getInsets().left;
        int y = getInsets().top;
        LinkedList<Card> cards = playground.getAllCards();
        for (Card c : cards) {
            BufferedImage img = c.isVisible() ? c.getImage() : c.getBack();
            img = rotateImageByDegrees(img, 90);
            g2d.drawImage(img, x,y, CARD_WIDTH, CARD_HEIGHT, this);
            x += CARD_WIDTH + 5;
            if (x > getWidth() - CARD_WIDTH) {
                x = getInsets().left;
                y += CARD_HEIGHT + 5;
            }
        }
    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {
        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, this);
        g2d.dispose();
        return rotated;
    }

    /**
     * Setzt den WindowHandler fuer das Frame.
     *
     * @param mainWindowHandler Fuegt einen WindowHandler zum Frame hinzu.
     */
    public void setHandler(MainWindowHandler mainWindowHandler) {
        addWindowListener(mainWindowHandler);
    }

    public void setMouseListener(MouseWindowHandler mouse) {
        addMouseListener(mouse);
        this.mouse = mouse;
    }

    public void setKeyListener(MainKeyListener keys) {
        addKeyListener(keys);
        this.keys = keys;
    }
}
