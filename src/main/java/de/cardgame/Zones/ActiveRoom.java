package de.cardgame.Zones;

import de.cardgame.Card;

public class ActiveRoom extends Zone<Card>{
    public ActiveRoom() {
        super("ActiveRoom");
    }

    public ActiveRoom(int limit) {
        super("ActiveRoom", limit);
    }

    @Override
    void setup() {

    }
}
