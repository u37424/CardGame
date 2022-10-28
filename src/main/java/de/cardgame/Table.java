package de.cardgame;

import de.cardgame.Window.Window;
import de.cardgame.Zones.*;

import java.util.LinkedList;

public class Table {
    private static Deck deck= new Deck();
    private static Dungeon dungeon = new Dungeon(Deck.getDeckSize());
    private static ActiveRoom activeRoom= new ActiveRoom(Deck.getDeckSize());
    private static Card leftRoom;
    private static Card rightRoom;
    private static Shop shop= new Shop();
    private static Gold gold= new Gold();
    private static Souls souls= new Souls();
    private static Items items= new Items();
    private static Backpack backpack= new Backpack();
    private static Shields shields= new Shields(2);
    private static Card scroll;
    private static Trash trash = new Trash(Deck.getDeckSize());
    private static Weapons weapons= new Weapons(6);
    private static DicePool dicePool= new DicePool(6);
    private static CarrySpace carrySpace = new CarrySpace(6);
    private static Dice scrollDice= new Dice();
    private static ShieldDice shieldDice= new ShieldDice(2);
    private static Health health = new Health();

    static {
        traverseStack(dungeon.getContent(), deck.getCards());

        leftRoom = dungeon.getLast();
        dungeon.removeLast();
        leftRoom.flip();

        rightRoom = dungeon.getLast();
        dungeon.removeLast();
        rightRoom.flip();

        carrySpace.add(dicePool.getLast());
        carrySpace.getLast().setFace(3);
        dicePool.removeLast();

        System.out.println("Health " + health.getHealthCards().size());
        System.out.println("Carryspace " + carrySpace.getCarryAmount());

        Window.endLoading();
    }

    public static Dungeon getDungeon() {
        return dungeon;
    }

    public static Card getLeftRoom() {
        return leftRoom;
    }

    public static Card getRightRoom() {
        return rightRoom;
    }

    public static ActiveRoom getActiveRoom() {
        return activeRoom;
    }

    public static Shop getShop() {
        return shop;
    }

    public static Gold getGold() {
        return gold;
    }

    public static Souls getSouls() {
        return souls;
    }

    public static Items getItems() {
        return items;
    }

    public static Backpack getBackpack() {
        return backpack;
    }

    public static Shields getShields() {
        return shields;
    }

    public static Card getScroll() {
        return scroll;
    }

    public static Trash getTrash() {
        return trash;
    }

    public static Weapons getWeapons() {
        return weapons;
    }

    public static DicePool getDicePool() {
        return dicePool;
    }

    public static CarrySpace getCarrySpace() {
        return carrySpace;
    }

    public static Dice getScrollDice() {
        return scrollDice;
    }

    public static ShieldDice getShieldDice() {
        return shieldDice;
    }

    public static Health getHealth() {
        return health;
    }

    public static void setLeftRoom(Card leftRoom) {
        Table.leftRoom = leftRoom;
    }

    public static void setRightRoom(Card rightRoom) {
        Table.rightRoom = rightRoom;
    }

    public static LinkedList<Card> getAllCards() {
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

    private static void traverseStack(LinkedList<Card> dest, LinkedList<Card> content) {
        dest.addAll(content);
    }
}
