package de.cardgame;

import de.cardgame.Window.FieldPositions;
import de.cardgame.Zones.*;

import java.util.LinkedList;

public class Table {
    private static Deck DECK;
    private Dungeon dungeon;
    private ActiveRoom activeRoom;
    private Card leftRoom;
    private Card rightRoom;
    private Shop shop;
    private Gold gold;
    private Souls souls;
    private Items items;
    private Backpack backpack;
    private Shields shields;
    private Card scroll;
    private Trash trash;
    private Weapons weapons;
    private DicePool dicePool;
    private CarrySpace carrySpace;
    private Dice scrollDice;
    private ShieldDice shieldDice;
    private Health health;

    public Table() {
        this.DECK = new Deck(this);
        dungeon = new Dungeon(Deck.getDeckSize());
        traverseStack(dungeon.getContent(), DECK.getCards());
        activeRoom = new ActiveRoom(Deck.getDeckSize());
        gold = new Gold();
        souls = new Souls();
        shop = new Shop();
        items = new Items();
        backpack = new Backpack();
        trash = new Trash(Deck.getDeckSize());
        weapons = new Weapons(6);
        shields = new Shields(2);
        dicePool = new DicePool(6);
        scrollDice = new Dice();
        carrySpace = new CarrySpace(6);
        shieldDice = new ShieldDice(2);
        health = new Health();

        setupTable();
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public Card getLeftRoom() {
        return leftRoom;
    }

    public Card getRightRoom() {
        return rightRoom;
    }

    public ActiveRoom getActiveRoom() {
        return activeRoom;
    }

    public Shop getShop() {
        return shop;
    }

    public Gold getGold() {
        return gold;
    }

    public Souls getSouls() {
        return souls;
    }

    public Items getItems() {
        return items;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public Shields getShields() {
        return shields;
    }

    public Card getScroll() {
        return scroll;
    }

    public Trash getTrash() {
        return trash;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public DicePool getDicePool() {
        return dicePool;
    }

    public CarrySpace getCarrySpace() {
        return carrySpace;
    }

    public Dice getScrollDice() {
        return scrollDice;
    }

    public ShieldDice getShieldDice() {
        return shieldDice;
    }

    public Health getHealth() {
        return health;
    }

    public void setLeftRoom(Card leftRoom) {
        this.leftRoom = leftRoom;
    }

    public void setRightRoom(Card rightRoom) {
        this.rightRoom = rightRoom;
    }

    private void setupTable() {
        leftRoom = dungeon.getFirst();
        dungeon.removeFirst();
        leftRoom.flip();

        rightRoom = dungeon.getFirst();
        dungeon.removeFirst();
        rightRoom.flip();

        carrySpace.add(dicePool.getFirst());
        carrySpace.getFirst().setFace(3);
        dicePool.removeFirst();

        System.out.println("Health " + health);
        System.out.println("Carryspace " + carrySpace.getCarrySpace());
    }

    public LinkedList<Card> getAllCards() {
        LinkedList<Card> cards = new LinkedList<>();
        traverseStack(cards, dungeon.getContent());
        traverseStack(cards, activeRoom.getContent());
        traverseStack(cards, shop.getContent());
        traverseStack(cards, trash.getContent());
        traverseStack(cards, souls.getContent());
        traverseStack(cards, gold.getContent());
        traverseStack(cards, items.getContent());
        traverseStack(cards, weapons.getContent());
        traverseStack(cards, shields.getContent());
        traverseStack(cards, backpack.getContent());
        cards.add(leftRoom);
        cards.add(rightRoom);
        return cards;
    }

    private void traverseStack(LinkedList<Card> dest, LinkedList<Card> content) {
        for (Card c : content) {
            dest.add(c);
        }
    }
}
