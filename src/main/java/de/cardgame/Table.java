package de.cardgame;

import java.util.LinkedList;

public class Table {
    private static Deck DECK;
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
    private int health;
    private int lostHealth;

    public Table() {
        this.DECK = new Deck(this);
        traverseStack(this.dungeon, DECK.getCards());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());
        dicepool.add(new Dice());

        scrollDice = new Dice();
        shieldDice.add(new Dice());
        shieldDice.add(new Dice());

        health = 41;
        lostHealth = 0;

        setupTable();
    }

    public LinkedList<Card> getDungeon() {
        return dungeon;
    }

    public Card getLeftRoom() {
        return leftRoom;
    }

    public Card getRightRoom() {
        return rightRoom;
    }

    private void setupTable() {
        leftRoom = dungeon.getFirst();
        dungeon.removeFirst();
        leftRoom.flip();

        rightRoom = dungeon.getFirst();
        dungeon.removeFirst();
        rightRoom.flip();

        carrySpace.add(dicepool.getFirst());
        carrySpace.getFirst().setFace(3);
        dicepool.removeFirst();

        System.out.println("Health " + health);
        System.out.println("Left " + leftRoom);
        System.out.println("Right " + rightRoom);
        System.out.println("Carryspace " + carrySpace.getFirst());
    }

    public LinkedList<Card> getAllCards() {
        LinkedList<Card> cards = new LinkedList<>();
        traverseStack(cards, dungeon);
        traverseStack(cards, activeRoom);
        traverseStack(cards, gold);
        traverseStack(cards, souls);
        traverseStack(cards, trash);
        traverseStack(cards, backpack);
        traverseStack(cards, items);
        cards.add(leftRoom);
        cards.add(rightRoom);
        traverseField(cards, weapons);
        traverseField(cards, shields);
        return cards;
    }

    private void traverseField(LinkedList<Card> cards, Card[] weapons) {
        if (weapons.length != 0) {
            for (int i = 0; i < weapons.length; i++) {
                if (weapons[i] != null) cards.add(weapons[i]);
            }
        }
    }

    private void traverseStack(LinkedList<Card> cards, LinkedList<Card> position) {
        for (Card c : position) {
            cards.add(c);
        }
    }
}
