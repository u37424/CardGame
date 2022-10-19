package de.cardgame.Zones;

import java.util.LinkedList;

public abstract class Zone<T> {
    private LinkedList<T> content;
    private String name;
    private boolean hasLimit;
    private int limit;
    private int OFFSET = 10;

    public Zone(String name){
        this.content = new LinkedList<>();
        this.name = name;
        this.hasLimit = false;
        this.limit = 0;
    }

    public Zone(String name, int limit){
        this.content = new LinkedList<>();
        this.name = name;
        this.hasLimit = true;
        this.limit = limit;
    }

    abstract void setup();

    public String getName(){
        return name;
    }

    public LinkedList<T> getContent(){
        return content;
    }

    public boolean isHasLimit() {
        return hasLimit;
    }

    public int getOFFSET() {
        return OFFSET;
    }

    public void setOFFSET(int OFFSET) {
        this.OFFSET = OFFSET;
    }

    public int getLimit() {
        return limit;
    }

    public T getFirst(){
        return getContent().getFirst();
    }

    public void removeFirst(){
        getContent().removeFirst();
    }

    public boolean add(T e) {
        if(isHasLimit() && getContent().size() >=getLimit()) return false;
        getContent().add(e);
        return true;
    }
}
