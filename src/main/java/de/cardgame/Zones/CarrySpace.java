package de.cardgame.Zones;

import de.cardgame.Dice;
import de.cardgame.Table;

public class CarrySpace extends Zone<Dice> {
    public CarrySpace() {
        super("CarrySpace");
    }

    public CarrySpace(int limit) {
        super("CarrySpace", limit);
    }

    @Override
    void setup() {

    }

    public boolean grow(int amount) {
        if (amount <= 0) return true;
        if (Table.getCarrySpace().getContent().size() > 0) {
            if (Table.getCarrySpace().getLast().getFace() < 6) {
                int temp = Math.min(6-Table.getCarrySpace().getLast().getFace(), amount);
                amount -= temp;
                temp = temp + Table.getCarrySpace().getLast().getFace();
                Table.getCarrySpace().getLast().setFace(temp);
                return grow(amount);
            }
        }
        if (Table.getDicePool().getSize() > 0) {
            Table.getDicePool().removeLast();
            Table.getCarrySpace().add(new Dice(Math.min(6, amount)));
            amount -= Table.getCarrySpace().getLast().getFace();
            return grow(amount);
        }
        return false;
    }

    public boolean shrink(int amount) {
        if(amount > Table.getCarrySpace().getCarryAmount()) return false;
        if(amount <= 0) return true;
        if (Table.getCarrySpace().getSize() > 0) {
            int temp = Math.min(Table.getCarrySpace().getLast().getFace(), amount);
            amount -= temp;
            if (Table.getCarrySpace().getLast().getFace() <= temp) {
                Table.getDicePool().add(new Dice(Table.getCarrySpace().getLast().getFace()));
                Table.getCarrySpace().removeLast();
            } else {
                Table.getCarrySpace().getLast().setFace(Table.getCarrySpace().getLast().getFace()-temp);
            }
            return shrink(amount);
        }
        return false;
    }

    public int getCarryAmount() {
        int amount = 0;
        for (Dice d : getContent()) {
            amount += d.getFace();
        }
        return amount;
    }
}
