package de.cardgame.Window;

import de.cardgame.Card;

import java.util.LinkedList;

public class FieldPositions {
    private int MIN_DISTANCE = 10;
    private Window w;
    private  int CENTER_X;
    private  int CENTER_Y;

    public FieldPositions(Window w){
        this.w = w;
        this.CENTER_X = w.getFrameSizeX()/2;
        this.CENTER_Y = w.getFrameSizeY()/2;
    }

    public int getCenterX() {
        return CENTER_X;
    }

    public int getCenterY() {
        return CENTER_Y;
    }

    public int getDungeonX(){
        return CENTER_X-(w.getCardWidth()/2);
    }

    public int getDungeonY(){
        return w.getInsets().top+10;
    }

    public int getLeftRoomX(){
        return getDungeonX()-w.getCardWidth()-MIN_DISTANCE;
    }

    public int getLeftRoomY(){
        return getDungeonY();
    }

    public int getRightRoomX(){
        return getDungeonX()+w.getCardWidth()+MIN_DISTANCE;
    }

    public int getRightRoomY(){
        return getDungeonY();
    }

    public int getActiveRoomX(){
        return getDungeonX();
    }

    public int getActiveRoomY(){
        return getDungeonY()+w.getCardHeight()+MIN_DISTANCE;
    }

    public int getShopX() {
        return getRightRoomX()+w.getCardWidth()*2+MIN_DISTANCE;
    }

    public int getShopY() {
        return getDungeonY();
    }

    public int getHealthX() {
        return MIN_DISTANCE;
    }

    public int getHealthY() {
        return w.getFrameSizeY()-w.getCardHeight()-MIN_DISTANCE;
    }

    public int getLostX() {
        return getHealthX();
    }

    public int getLostY() {
        return getHealthY()-w.getCardHeight()-MIN_DISTANCE;
    }
}
