package de.cardgame.Window;

import de.cardgame.Card;
import de.cardgame.Table;

import java.util.LinkedList;

public class FieldPositions {
    private static int MIN_DISTANCE = 10;
    private Window w;
    private static int CENTER_X;
    private static int CENTER_Y;
    private static int SOULS_OFFSET;
    private static int GOLD_OFFSET;
    private static int FRAME_X;
    private static int FRAME_Y;

    public FieldPositions(Window w) {
        this.w = w;
        CENTER_X = w.getFrameSizeX() / 2;
        CENTER_Y = w.getFrameSizeY() / 2;
        FRAME_X = w.getFrameSizeX();
        FRAME_Y = w.getFrameSizeY();
    }

    public int getCenterX() {
        return CENTER_X;
    }

    public int getCenterY() {
        return CENTER_Y;
    }

    public int getMIN_DISTANCE() {
        return MIN_DISTANCE;
    }

    public int getDungeonX() {
        return CENTER_X - (w.getCardWidth() / 2);
    }

    public int getDungeonY() {
        return w.getInsets().top + 10;
    }

    public int getLeftRoomX() {
        return getDungeonX() - w.getCardWidth() - MIN_DISTANCE;
    }

    public int getLeftRoomY() {
        return getDungeonY();
    }

    public int getRightRoomX() {
        return getDungeonX() + w.getCardWidth() + MIN_DISTANCE;
    }

    public int getRightRoomY() {
        return getDungeonY();
    }

    public int getActiveRoomX() {
        return getDungeonX();
    }

    public int getActiveRoomY() {
        return getDungeonY() + w.getCardHeight() + MIN_DISTANCE;
    }

    public int getShopX() {
        return getRightRoomX() + w.getCardWidth() + MIN_DISTANCE;
    }

    public int getShopY() {
        return getDungeonY();
    }

    public int getHealthX() {
        return MIN_DISTANCE;
    }

    public int getHealthY() {
        return w.getFrameSizeY() - w.getCardHeight() - MIN_DISTANCE;
    }

    public int getLostX() {
        return getHealthX();
    }

    public int getLostY() {
        return getHealthY() - w.getCardHeight() - MIN_DISTANCE;
    }

    public static void setSOULS_OFFSET() {
        SOULS_OFFSET = (int) (FRAME_X*0.035) - Table.getSouls().getSize() * 2;
    }

    public static int getSOULS_OFFSET() {
        return SOULS_OFFSET;
    }

    public static void setGoldOffset() {

        GOLD_OFFSET = (int) (FRAME_X*0.035)  - Table.getGold().getSize() * 2;
    }

    public static int getGoldOffset() {
        return GOLD_OFFSET;
    }

    public int getSoulsX(int i) {
        int base = MIN_DISTANCE;
        if (i == 0) return base;
        setSOULS_OFFSET();
        return base + getSOULS_OFFSET() * i;
    }

    public int getSoulsY(int i) {
        return getDungeonY();
    }

    public int getGoldX(int i) {
        int base = getLeftRoomX() - MIN_DISTANCE - w.getCardWidth();
        if (i == 0) return base;
        setGoldOffset();
        return base + getGoldOffset() * i;
    }

    public int getGoldY(int i) {
        return getHealthY();
    }

    public int getTrashX() {
        return w.getFrameSizeX() - MIN_DISTANCE - w.getCardWidth();
    }

    public int getTrashY() {
        return getDungeonY();
    }

    public int getPoolLeftMiddleX() {
        return getHealthX()+w.getCardWidth()+MIN_DISTANCE;
    }

    public int getPoolLeftMiddleY() {
        return getHealthY()+(w.getCardHeight()/2)-(w.getDiceHeight()/2);
    }

    public int getPoolRightMiddleX() {
        return getPoolLeftMiddleX()+w.getDiceWidth()+MIN_DISTANCE;
    }

    public int getPoolRightMiddleY() {
        return getPoolLeftMiddleY();
    }

    public int getPoolLeftTopX() {
        return getPoolLeftMiddleX();
    }

    public int getPoolLeftTopY() {
        return getPoolLeftMiddleY()-w.getDiceHeight()-MIN_DISTANCE;
    }

    public int getPoolLeftBottomX() {
        return getPoolLeftMiddleX();
    }

    public int getPoolLeftBottomY() {
        return getPoolLeftMiddleY()+w.getDiceHeight()+MIN_DISTANCE;
    }

    public int getPoolRightTopX() {
        return getPoolRightMiddleX();
    }

    public int getPoolRightTopY() {
        return getPoolRightMiddleY()-w.getDiceHeight()-MIN_DISTANCE;
    }

    public int getPoolRightBottomX() {
        return getPoolRightMiddleX();
    }

    public int getPoolRightBottomY() {
        return getPoolRightMiddleY()+w.getDiceHeight()+MIN_DISTANCE;
    }

    public int getPoolLeftBetweenTopX() {
        return getPoolLeftMiddleX();
    }

    public int getPoolLeftBetweenTopY() {
        return getPoolLeftMiddleY()-w.getDiceHeight()/2-MIN_DISTANCE/2;
    }

    public int getPoolLeftBetweenBottomX() {
        return getPoolLeftMiddleX();
    }

    public int getPoolLeftBetweenBottomY() {
        return getPoolLeftMiddleY()+w.getDiceHeight()/2+MIN_DISTANCE/2;
    }

    public int getPoolRightBetweenTopX() {
        return getPoolRightMiddleX();
    }

    public int getPoolRightBetweenTopY() {
        return getPoolRightMiddleY()-w.getDiceHeight()/2-MIN_DISTANCE/2;
    }

    public int getPoolRightBetweenBottomX() {
        return getPoolRightMiddleX();
    }

    public int getPoolRightBetweenBottomY() {
        return getPoolRightMiddleY()+w.getDiceHeight()/2+MIN_DISTANCE/2;
    }
}
