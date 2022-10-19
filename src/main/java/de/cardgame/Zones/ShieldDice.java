package de.cardgame.Zones;

import de.cardgame.Dice;

public class ShieldDice extends Zone<Dice> {
    public ShieldDice() {
        super("ShieldDice");
        setup();
    }

    public ShieldDice( int limit) {
        super("ShieldDice", limit);
        setup();
    }

    @Override
    void setup() {
        add(new Dice());
        add(new Dice());
    }
}
