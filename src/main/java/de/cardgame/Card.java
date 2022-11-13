package de.cardgame;

import de.cardgame.Window.FileManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {
    //Jede Karte hat eine Farbe und einen Wert
    private Suit SUIT;
    private final Value VALUE;
    private int healthValue;

    private boolean visible;

    //Setzen der Kartenrückseite
    private static BufferedImage back;

    static {
        if (!FileManager.exist()) {
            System.err.println("Directories changed.");
        } else {
            //Find Backsides
            String path = findBGFile();
            if (path == null || path == "") {
                System.err.println("Image for Backsides not found!");
            }

            //Backsides laden
            try {
                BufferedImage img = javax.imageio.ImageIO.read(new File(path));
                back = img;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Jede Karte hat ein assoziiertes Bild
    private BufferedImage image;

    public Card(Suit suit, Value value) {
        this.SUIT = suit;
        this.VALUE = value;
        this.visible = false;
        //Setzt das Bild der Karte
        setImg();
    }

    public Suit getSUIT() {
        return SUIT;
    }

    public Value getVALUE() {
        return VALUE;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public static BufferedImage getBack() {
        return back;
    }

    public boolean setImg() {
        if (!FileManager.exist()) return false;

        //Finde konkrete File
        String path = findIMGFile();
        if (path == null || path == "") {
            System.err.println("Image for " + getVALUE() + " " + getSUIT() + " not found!");
            return false;
        }

        //Image Laden
        try {
            BufferedImage img = javax.imageio.ImageIO.read(new File(path));
            this.image = img;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String findIMGFile() {
        String path;
        if (this.getSUIT().equals(Suit.HEALTH) || this.getSUIT().equals(Suit.HEALTH_LOST))
            path = FileManager.getHealthDir() + "/C_" + getSUIT();
        else if (this.getSUIT().equals(Suit.GOLD))
            path = FileManager.getGoldDir() + "/C_" + getSUIT() + "_" + getVALUE();
        else if (this.getSUIT().equals(Suit.SOULS))
            path = FileManager.getSoulsDir() + "/C_" + getSUIT() + "_" + getVALUE();
        else path = FileManager.getCardDir() + "/C_" + getSUIT() + "_" + getVALUE();
        if (FileManager.findFile(path + ".jpg")) return path + ".jpg";
        else if ((FileManager.findFile(path + ".png"))) return path + ".png";
        else return "";

    }

    private static String findBGFile() {
        String path = FileManager.getCardDir();
        //Backsides suchen
        if (FileManager.findFile(path + "/C_BACK.jpg")) {
            path += "/C_BACK.jpg";
        } else if (FileManager.findFile(path + "/C_BACK.png")) {
            path += "/C_BACK.png";
        } else {
            return "";
        }
        return path;
    }

    @Override
    public String toString() {
        return getSUIT().getSymbol() + getVALUE().getSymbol();
    }

    public void flip() {
        setVisible(!isVisible());
    }

    public BufferedImage getFacingSide() {
        return isVisible() ? getImage() : getBack();
    }

    public void changeSUIT(Suit suit) {
        this.SUIT = suit;
        this.setImg();
    }
}
