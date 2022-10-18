package de.cardgame;

import javax.crypto.spec.PSource;
import java.util.LinkedList;
import java.util.List;

public class Table {
    private Deck DECK;
    private LinkedList<Card> dungeon = new LinkedList<>();
    private LinkedList<Card> activeRoom = new LinkedList<>();
    private Card leftRoom;
    private Card rightRoom;
    private LinkedList<Card> shop = new LinkedList<>();
    private LinkedList<Card> souls = new LinkedList<>();
    private LinkedList<Card> gold = new LinkedList<>();
    private LinkedList<Card> items = new LinkedList<>();
    private Card[] weapons = new Card[6];
    private LinkedList<Card> backpack = new LinkedList<>();
    private Card[] shields = new Card[2];
    private Card scroll;
    private LinkedList<Card> trash = new LinkedList<>();
    private LinkedList<Dice> dicepool = new LinkedList<>();
    private LinkedList<Dice> carrySpace = new LinkedList<>();
    private Dice scrollDice;
    private LinkedList<Dice> shieldDice = new LinkedList<>();

    public Table() {
        this.DECK = new Deck(this);
        for (Card card : DECK.getCards()) {
            this.dungeon.add(card);
        }
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        scrollDice = new Dice();
        shieldDice.add(new Dice());
        shieldDice.add(new Dice());
        setupTable();
    }

    private void setupTable() {
        leftRoom = dungeon.getFirst();
        dungeon.removeFirst();
        rightRoom = dungeon.getFirst();
        dungeon.removeFirst();
        carrySpace.add(dicepool.getFirst());
        carrySpace.getFirst().setFace(3);
        dicepool.removeFirst();
        System.out.println("Left "+leftRoom);
        System.out.println("Right "+rightRoom);
        System.out.println("Carryspace "+carrySpace.getFirst());
    }
}
