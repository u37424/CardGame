package de.cardgame.Window;

import de.cardgame.Card;
import de.cardgame.Dice;
import de.cardgame.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Window extends JFrame {

    private static final int FRAME_SIZE_X = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int FRAME_SIZE_Y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final Color BACKGROUND = Color.BLACK;
    private static final int CARD_WIDTH = 138;
    private static final int CARD_HEIGHT = 190;
    private static final int DICE_WIDTH = 35;
    private static final int DICE_HEIGHT = 35;
    private MouseWindowHandler mouse;
    private MainKeyListener keys;
    private final Table playground;
    private FieldPositions pos;


    public Window(Table table) {
        setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
        setResizable(true);
        setTitle("LEGEND v.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(Color.BLACK);
        this.setVisible(true);
        setBackground(BACKGROUND);
        this.playground = table;
        pos = new FieldPositions(this);
    }

    /**
     * Zeichnet die Inhalte der Zeichenebene inklusive aller vorhandenen Drawables.
     *
     * @param g Grafik
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
        if(playground.getDungeon().getSize() > 0) drawDungeon(g2d);
        if(playground.getLeftRoom() != null) drawLeftRoom(g2d);
        if(playground.getRightRoom()!= null) drawRightRoom(g2d);
        if(playground.getActiveRoom().getSize() != 0) drawActive(g2d);
        if(playground.getShop().getSize() != 0) drawShop(g2d);
        if(playground.getHealth().hasHealth()) drawHealth(g2d);
        if(playground.getHealth().hasLost()) drawLost(g2d);
        //drawAll(g2d);
    }

    private void drawLost(Graphics2D g2d) {
        BufferedImage img = playground.getHealth().getLostCard().getImage();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getLostX(), pos.getLostY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawHealth(Graphics2D g2d) {
        BufferedImage img = playground.getHealth().getHealthCard().getImage();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getHealthX(), pos.getHealthY(), CARD_WIDTH, CARD_HEIGHT, this);
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Courier New", Font.BOLD, 15));
        g2d.drawString(Integer.toString(playground.getHealth().getHealthCards().size()),
                pos.getHealthX()+getCardWidth()+5, pos.getHealthY()+10);
    }

    private void drawShop(Graphics2D g2d) {
        BufferedImage img = playground.getShop().getLast().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getShopX(), pos.getShopY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawActive(Graphics2D g2d) {
        BufferedImage img = playground.getActiveRoom().getLast().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getActiveRoomX(), pos.getActiveRoomY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawDungeon(Graphics2D g2d) {
        BufferedImage img = playground.getDungeon().getFirst().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getDungeonX(), pos.getDungeonY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawLeftRoom(Graphics2D g2d) {
        BufferedImage img = playground.getLeftRoom().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getLeftRoomX(), pos.getLeftRoomY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawRightRoom(Graphics2D g2d) {
        BufferedImage img = playground.getRightRoom().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getRightRoomX(), pos.getRightRoomY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawAll(Graphics2D g2d) {
        int x = getInsets().left;
        int y = getInsets().top;
        LinkedList<Card> cards = playground.getAllCards();
        for (Card c : cards) {
            BufferedImage img = c.getFacingSide();
            img = rotateImageByDegrees(img, 90);
            g2d.drawImage(img, x, y, CARD_WIDTH, CARD_HEIGHT, this);
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

    public int getFrameSizeX() {
        return FRAME_SIZE_X;
    }

    public int getFrameSizeY() {
        return FRAME_SIZE_Y;
    }

    public int getCardHeight() {
        return CARD_HEIGHT;
    }

    public int getCardWidth() {
        return CARD_WIDTH;
    }

    public FieldPositions getPos() {
        return pos;
    }
}
