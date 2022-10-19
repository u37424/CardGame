package de.cardgame.Zones;

import de.cardgame.Dice;

public class CarrySpace extends Zone<Dice>{
    public CarrySpace() {
        super("CarrySpace");
    }

    public CarrySpace(int limit) {
        super("CarrySpace", limit);
    }

    @Override
    void setup() {

    }

    public int getCarrySpace(){
        int amount = 0;
        for (Dice d : getContent()) {
            amount += d.getFace();
        }
        return amount;
    }
}
