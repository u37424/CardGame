package de.cardgame;

import de.cardgame.Zones.Health;
import de.cardgame.Zones.Souls;

public class Fight {
    public static void engage() {
        Health.lose();
        Souls.takeNew();
    }
}
