package de.cardgame;

import java.awt.*;

public enum Skin {
    DICE("DICE"), SHIELD("SHIELD"), SCROLL("SCROLL");

    private final String name;

    Skin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
