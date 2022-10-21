package de.cardgame;

import java.awt.*;

public enum Suit {
    HEARTS(Color.RED, "Enemy", "\u2661"), DIAMONDS(Color.RED, "Resource", "\u2662"),
    SPADES(Color.BLACK,"Weapon", "\u2660"), CLUBS(Color.BLACK,"Empty Room", "\u2663"),
    HEALTH(Color.RED, "Health", "H"), HEALTH_LOST(Color.LIGHT_GRAY, "Lost Health", "LH");

    private final Color color;
    private final String function;
    private final String symbol;

    Suit(Color color, String function, String symbol) {
        this.color = color;
        this.function = function;
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public String getFunction() {
        return function;
    }

    public String getSymbol() {
        return symbol;
    }
}
