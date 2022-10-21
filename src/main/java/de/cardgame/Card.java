package de.cardgame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Card {
    //Jede Karte hat eine Farbe und einen Wert
    private final Suit SUIT;
    private final Value VALUE;

    private boolean visible;

    //Setzen der Kartenrückseite
    private static BufferedImage back;

    static {
        if (FileManager.findDirectory(FileManager.getImgDir())) {
            String path = FileManager.getImgDir();
            if (FileManager.findFile(path + "/C_BACK.jpg")) {
                path += "/C_BACK.jpg";
            } else if (FileManager.findFile(path + "/C_BACK.png")) {
                path += "/C_BACK.jppng";
            } else {
                System.err.println("No Back Image Found.");
            }
            try {
                BufferedImage img = javax.imageio.ImageIO.read(new File(path));
                back = img;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No Directory for Backside image found!");
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

    public static BufferedImage getBack() {
        return back;
    }

    public boolean setImg() {
        //Finde Directory
        if (!FileManager.findDirectory(FileManager.getImgDir())) {
            System.err.println("Cannot find Card Image Folder!");
            return false;
        }
        //Finde konkrete File
        String path = findIMGFile();
        if (path == null || path == "") {
            //SUPPRESSED WARNING!!!!!!!!!
            //System.err.println("Image for "+getVALUE()+" "+getSUIT() +" not found!");
            return false;
        }

        //Image Laden
        try {
            BufferedImage img = javax.imageio.ImageIO.read(new File(path));
            this.image = img;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String findIMGFile() {
        String path = "";
        if (this.getSUIT().equals(Suit.HEALTH) || this.getSUIT().equals(Suit.HEALTH_LOST))
            path = FileManager.getImgDir() + "/C_" + getSUIT();
        else path = FileManager.getImgDir() + "/C_" + getSUIT() + "_" + getVALUE();
        if (FileManager.findFile(path + ".jpg")) return path + ".jpg";
        else if ((FileManager.findFile(path + ".png"))) return path + ".png";
        else return "";

    }

    @Override
    public String toString() {
        return getSUIT().getSymbol() + getVALUE().getSymbol();
    }

    public void flip() {
        if (isVisible()) setVisible(false);
        else setVisible(true);
    }

    public BufferedImage getFacingSide() {
        return isVisible() ? getImage() : getBack();
    }
}
