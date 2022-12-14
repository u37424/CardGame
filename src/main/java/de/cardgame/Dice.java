package de.cardgame;

import de.cardgame.Window.FileManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Dice {
    private int face;
    private String symbol;
    private Skin skin;

    private BufferedImage image;

    public Dice(Skin skin) {
        this.skin = skin;
        roll();
        updateSymbol();
    }

    public Dice(int face, Skin skin) {
        this.skin = skin;
        setFace(face);
        updateSymbol();
    }

    private void updateSymbol() {
        if (face == 1) symbol = "\u2680";
        if (face == 2) symbol = "\u2681";
        if (face == 3) symbol = "\u2682";
        if (face == 4) symbol = "\u2683";
        if (face == 5) symbol = "\u2684";
        if (face == 6) symbol = "\u2685";
    }

    private void roll() {
        Random r = new Random();
        face = r.nextInt(1, 6);
        updateSymbol();
        setImg();
    }

    public void setFace(int face) {
        this.face = face;
        updateSymbol();
        setImg();
    }

    public int getFace() {
        return face;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean setImg() {
        if(!FileManager.exist()) return false;

        //Finde konkrete File
        String path = findIMGFile();
        if (path == null || path == "") {
            System.err.println("Image for " + skin.getName()+"_"+ convertFace() + " not found!");
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
        String path = FileManager.getDiceDir() + "/D_" + this.skin.getName() + "_" + convertFace();
        if (FileManager.findFile(path + ".jpg")) return path + ".jpg";
        else if ((FileManager.findFile(path + ".png"))) return path + ".png";
        else return "";
    }

    private String convertFace() {
        if (getFace() == 1) return "ONE";
        if (getFace() == 2) return "TWO";
        if (getFace() == 3) return "THREE";
        if (getFace() == 4) return "FOUR";
        if (getFace() == 5) return "FIVE";
        if (getFace() == 6) return "SIX";
        return "ERROR_" + getFace();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
