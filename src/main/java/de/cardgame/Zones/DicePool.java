package de.cardgame.Zones;

import de.cardgame.Dice;

public class DicePool extends Zone<Dice>{
    public DicePool() {
        super("DicePool");
        setup();
    }

    public DicePool(int limit) {
        super("DicePool", limit);
        setup();
    }

    @Override
    void setup() {
        getContent().add(new Dice());
        getContent().add(new Dice());
        getContent().add(new Dice());
        getContent().add(new Dice());
        getContent().add(new Dice());
        getContent().add(new Dice());
    }
}
