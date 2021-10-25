package Persist;

import Core.*;

import java.util.Date;

public class EntryJdbc extends Entry {
    /**
     * @param score
     * @param gameDate
     * @param player
     */
    public EntryJdbc(int score, Date gameDate, Player player) {
        super(score, gameDate, player);
    }
}