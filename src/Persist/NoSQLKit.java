package Persist;

import Core.Entry;
import Core.HighScore;
import Core.Player;

import java.util.Date;

public class NoSQLKit implements PersistKit{
    @Override
    public HighScore makeHighScoreKit() {
        return new HighScoreMongo("localhost",27017,"dicegame","highscore");
    }

    @Override
    public Entry makeEntryKit() {
        return null;
    }

    public static void main(String[] args){

        HighScore highScore = (new NoSQLKit()).makeHighScoreKit();
        highScore.save(new Entry(777,new Date(),new Player("Aaron")));
        highScore.save(new Entry(777,new Date(),new Player("Fanchardy")));
        highScore.load();
    }
}
