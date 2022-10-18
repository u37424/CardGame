package de.cardgame;

import java.util.Random;

public class Dice {
    private int face;
    private String symbol;

    public Dice() {
        roll();
        updateSymbol();
    }

    private void updateSymbol() {
        if(face == 1) symbol = "\u2680";
        if(face == 2) symbol = "\u2681";
        if(face == 3) symbol = "\u2682";
        if(face == 4) symbol = "\u2683";
        if(face == 5) symbol = "\u2684";
        if(face == 6) symbol = "\u2685";
    }

    private void roll() {
        Random r = new Random();
        face = r.nextInt(1, 6);
    }

    public void setFace(int face) {
        this.face = face;
        updateSymbol();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
