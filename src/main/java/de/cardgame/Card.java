package de.cardgame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Card {
    private final Suit SUIT;
    private final Value VALUE;
    private final Deck deck;
    private BufferedImage image;

    public Card(Suit suit, Value value, Deck deck) {
        this.SUIT = suit;
        this.VALUE = value;
        this.deck = deck;
        if(!setPng()) System.err.println("Image for "+getVALUE()+" "+getSUIT() +" not found!");
    }

    public Suit getSUIT() {
        return SUIT;
    }

    public Value getVALUE() {
        return VALUE;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean setPng() {
        if (!FileManager.findDirectory(FileManager.getCardImgDir())) {
            System.err.println("Cannot find Card Image Folder!");
            return false;
        }
        String path = findIMGFile();
        if (path == null || path == "") return false;
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
        String path = FileManager.getCardImgDir() + "/C_" + getSUIT() + "_" + getVALUE();
        if (FileManager.findFile(path + ".jpg")) return path + ".jpg";
        else if ((FileManager.findFile(path + ".png"))) return path + ".png";
        else return "";

    }

    @Override
    public String toString() {
        return getSUIT().getSymbol()+getVALUE().getSymbol();
    }
}
