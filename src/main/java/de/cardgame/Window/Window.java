package de.cardgame.Window;

import de.cardgame.Card;
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
    private static final int CARD_WIDTH = (int) (FRAME_SIZE_X * 0.08);
    private static final int CARD_HEIGHT = (int) (CARD_WIDTH * 1.4);
    private static final int DICE_WIDTH = (int) (FRAME_SIZE_X * 0.02);
    private static final int DICE_HEIGHT = DICE_WIDTH;
    private MouseWindowHandler mouse;
    private MainKeyListener keys;
    private FieldPositions pos;
    private static boolean loading = true;

    public Window() {
        setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
        System.out.println("X " + getFrameSizeX() + " Y " + getFrameSizeY());
        setResizable(true);
        setTitle("LEGEND v.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(BACKGROUND);
        pos = new FieldPositions(this);
        this.setVisible(true);
    }

    public static void endLoading() {
        loading = false;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, (int) getSize().getWidth(), (int) getSize().getHeight());
        if (loading) {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Courier New", Font.BOLD, 50));
            g2d.drawString("Loading...\n", pos.getCenterX() - 150, pos.getCenterY() - 25);
        }
        if (Table.getDungeon().getSize() > 0) drawDungeon(g2d);
        if (Table.getLeftRoom() != null) drawLeftRoom(g2d);
        if (Table.getRightRoom() != null) drawRightRoom(g2d);
        if (Table.getActiveRoom().getSize() != 0) drawActive(g2d);
        if (Table.getDicePool().getSize() > 0) drawDicePool(g2d);
        if (Table.getCarrySpace().getSize() > 0) drawCarrySpace(g2d);
        if (Table.getShop().getSize() > 0) drawShop(g2d);
        if (Table.getTrash().getSize() > 0) drawTrash(g2d);
        if (Table.getHealth().hasHealth()) drawHealth(g2d);
        if (Table.getHealth().hasLost()) drawLost(g2d);
        if (Table.getSouls().getSize() > 0) drawSouls(g2d);
        if (Table.getGold().getSize() > 0) drawGold(g2d);
        //drawAll(g2d);
    }

    private void drawCarrySpace(Graphics2D g2d) {
        int s = Table.getCarrySpace().getSize();
        for (int i = 0; i < s; i++) {
            int x = 0;
            int y = 0;
            switch (i) {
                case 0:
                    if (s == 1 || s == 2) {
                        x = pos.getPoolLeftMiddleX();
                        y = pos.getPoolLeftMiddleY();
                    } else if (s == 3 || s == 4) {
                        x = pos.getPoolLeftBetweenTopX();
                        y = pos.getPoolLeftBetweenTopY();
                    } else if (s == 5 || s == 6) {
                        x = pos.getPoolLeftTopX();
                        y = pos.getPoolLeftTopY();
                    }
                    break;
                case 1:
                    if (s == 2) {
                        x = pos.getPoolRightMiddleX();
                        y = pos.getPoolRightMiddleY();
                    } else if (s == 3 || s == 4) {
                        x = pos.getPoolRightBetweenTopX();
                        y = pos.getPoolRightBetweenTopY();
                    } else if (s == 5 || s == 6) {
                        x = pos.getPoolRightTopX();
                        y = pos.getPoolRightTopY();
                    }
                    break;

                case 2:
                    if (s == 3 || s == 4) {
                        x = pos.getPoolLeftBetweenBottomX();
                        y = pos.getPoolLeftBetweenBottomY();
                    } else if (s == 5 || s == 6) {
                        x = pos.getPoolLeftMiddleX();
                        y = pos.getPoolLeftMiddleY();
                    }
                    break;
                case 3:
                    if (s == 4) {
                        x = pos.getPoolRightBetweenBottomX();
                        y = pos.getPoolRightBetweenBottomY();
                    } else if (s == 5 || s == 6) {
                        x = pos.getPoolRightMiddleX();
                        y = pos.getPoolRightMiddleY();
                    }
                    break;
                case 4:
                    x = pos.getPoolLeftBottomX();
                    y = pos.getPoolLeftBottomY();
                    break;
                case 5:
                    x = pos.getPoolRightBottomX();
                    y = pos.getPoolRightBottomY();
                    break;
            }
            BufferedImage img = Table.getCarrySpace().getIndex(i).getImage();
            drawDiceAtXY(img, x+getDiceWidth()*4+pos.getMIN_DISTANCE()*3, y, g2d);
        }
    }

    private void drawDicePool(Graphics2D g2d) {
        int s = Table.getDicePool().getSize();
        for (int i = 0; i < s; i++) {
            int x = 0;
            int y = 0;
            switch (i) {
                case 0:
                    if (s == 1 || s == 2) {
                        x = pos.getPoolLeftMiddleX();
                        y = pos.getPoolLeftMiddleY();
                    } else if (s == 3 || s == 4) {
                        x = pos.getPoolLeftBetweenTopX();
                        y = pos.getPoolLeftBetweenTopY();
                    } else if (s == 5 || s == 6) {
                        x = pos.getPoolLeftTopX();
                        y = pos.getPoolLeftTopY();
                    }
                    break;
                case 1:
                    if (s == 2) {
                        x = pos.getPoolRightMiddleX();
                        y = pos.getPoolRightMiddleY();
                    } else if (s == 3 || s == 4) {
                        x = pos.getPoolLeftBetweenBottomX();
                        y = pos.getPoolLeftBetweenBottomY();
                    } else if (s == 5 || s == 6) {
                        x = pos.getPoolLeftBottomX();
                        y = pos.getPoolLeftBottomY();
                    }
                    break;

                case 2:
                    if (s == 3) {
                        x = pos.getPoolRightMiddleX();
                        y = pos.getPoolRightMiddleY();
                    } else if (s == 4 || s == 5) {
                        x = pos.getPoolRightBetweenTopX();
                        y = pos.getPoolRightBetweenTopY();
                    } else if (s == 6) {
                        x = pos.getPoolRightTopX();
                        y = pos.getPoolRightTopY();
                    }
                    break;
                case 3:
                    if (s == 4 || s == 5) {
                        x = pos.getPoolRightBetweenBottomX();
                        y = pos.getPoolRightBetweenBottomY();
                    } else if (s == 6) {
                        x = pos.getPoolRightBottomX();
                        y = pos.getPoolRightBottomY();
                    }
                    break;
                case 4:
                    x = pos.getPoolLeftMiddleX();
                    y = pos.getPoolLeftMiddleY();
                    break;
                case 5:
                    x = pos.getPoolRightMiddleX();
                    y = pos.getPoolRightMiddleY();
                    break;
            }
            BufferedImage img = Table.getDicePool().getIndex(i).getImage();
            drawDiceAtXY(img, x, y, g2d);
        }
    }

    private void drawDiceAtXY(BufferedImage img, int x, int y, Graphics2D g2d) {
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, x, y, DICE_WIDTH, DICE_HEIGHT, this);
    }

    private void drawTrash(Graphics2D g2d) {
        BufferedImage img = Table.getTrash().getLast().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getTrashX(), pos.getTrashY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawGold(Graphics2D g2d) {
        for (int i = 0; i < Table.getGold().getContent().size(); i++) {
            BufferedImage img = Table.getGold().getContent().get(i).getFacingSide();
            img = rotateImageByDegrees(img, 90);
            g2d.drawImage(img, pos.getGoldX(i), pos.getGoldY(i), CARD_WIDTH, CARD_HEIGHT, this);
        }
    }

    private void drawSouls(Graphics2D g2d) {
        for (int i = 0; i < Table.getSouls().getContent().size(); i++) {
            BufferedImage img = Table.getSouls().getContent().get(i).getFacingSide();
            img = rotateImageByDegrees(img, 90);
            g2d.drawImage(img, pos.getSoulsX(i), pos.getSoulsY(i), CARD_WIDTH, CARD_HEIGHT, this);
        }
    }

    private void drawLost(Graphics2D g2d) {
        BufferedImage img = Table.getHealth().getLostCard().getImage();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getLostX(), pos.getLostY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawHealth(Graphics2D g2d) {
        BufferedImage img = Table.getHealth().getHealthCard().getImage();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getHealthX(), pos.getHealthY(), CARD_WIDTH, CARD_HEIGHT, this);
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Courier New", Font.BOLD, 15));
        g2d.drawString(Integer.toString(Table.getHealth().getHealthCard().getHealthValue()),
                pos.getHealthX() + getCardWidth() + 5, pos.getHealthY() + 10);
    }

    private void drawShop(Graphics2D g2d) {
        BufferedImage img = Table.getShop().getLast().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getShopX(), pos.getShopY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawActive(Graphics2D g2d) {
        BufferedImage img = Table.getActiveRoom().getLast().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getActiveRoomX(), pos.getActiveRoomY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawDungeon(Graphics2D g2d) {
        BufferedImage img = Table.getDungeon().getLast().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getDungeonX(), pos.getDungeonY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawLeftRoom(Graphics2D g2d) {
        BufferedImage img = Table.getLeftRoom().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getLeftRoomX(), pos.getLeftRoomY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawRightRoom(Graphics2D g2d) {
        BufferedImage img = Table.getRightRoom().getFacingSide();
        img = rotateImageByDegrees(img, 90);
        g2d.drawImage(img, pos.getRightRoomX(), pos.getRightRoomY(), CARD_WIDTH, CARD_HEIGHT, this);
    }

    private void drawAll(Graphics2D g2d) {
        int x = getInsets().left;
        int y = getInsets().top;
        LinkedList<Card> cards = Table.getAllCards();
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

    public int getDiceHeight() {
        return DICE_HEIGHT;
    }

    public int getDiceWidth() {
        return DICE_WIDTH;
    }

    public FieldPositions getPos() {
        return pos;
    }
}
