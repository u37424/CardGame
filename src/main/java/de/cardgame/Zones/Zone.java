package de.cardgame.Zones;

import de.cardgame.Card;

import java.util.LinkedList;

public abstract class Zone<T> {
    private LinkedList<T> content;
    private String name;
    private boolean hasLimit;
    private int limit;

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

    public int getLimit() {
        return limit;
    }

    public boolean add(T e) {
        if(isHasLimit() && getContent().size() >=getLimit()) return false;
        getContent().add(e);
        return true;
    }

    public int getSize() {
        return getContent().size();
    }

    public T getLast(){
        return getContent().getLast();
    }

    public void removeLast(){
        getContent().removeLast();
    }
}
