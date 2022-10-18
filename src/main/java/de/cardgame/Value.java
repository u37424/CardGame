package de.cardgame;

public enum Value {
    TWO(2, 1, "2"), THREE(3, 1, "3"), FOUR(4, 1, "4"), FIVE(5, 1, "5"),
    SIX(6, 2, "6"), SEVEN(7, 2, "7"), EIGHT(8,2, "8"),
    NINE(9,2, "9"), TEN(10,3, "10"), JACK(11,3, "J"), QUEEN(12, 3, "Q"),
    KING(13,3, "K"), ACE(14, 4, "A");

    private final int value;
    private final int group;
    private final String symbol;

    Value(int value, int group, String symbol) {
        this.value = value;
        this.group = group;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public int getGroup() {
        return group;
    }

    public String getSymbol() {
        return symbol;
    }
}
