package de.cardgame.Zones;

import de.cardgame.Dice;
import de.cardgame.Skin;

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
        getContent().add(new Dice(Skin.DICE));
        getContent().add(new Dice(Skin.DICE));
        getContent().add(new Dice(Skin.DICE));
        getContent().add(new Dice(Skin.DICE));
        getContent().add(new Dice(Skin.DICE));
        getContent().add(new Dice(Skin.DICE));
    }
}
