package Ctrls;

import Core.*;
import Persist.JdbcKit;
import Persist.NoSQLKit;
import Persist.PersistKit;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

public class Ctrl {

	public static void play(List<Player> players, Observer dice1View, Observer dice2View, Observer strokesTableView) {
		// TODO - implement Ctrls.Ctrl.play
		//List<Player> pls = players;
		DiceGame.getInstance().start(players,dice1View,dice2View,strokesTableView);
	}

	public static void rollDices(String strategy, String name){
		DiceGame.getInstance().rollDices(strategy,name);
	}

	public void consulterScore() {
		// TODO - implement Ctrls.Ctrl.consulterScore
		throw new UnsupportedOperationException();
	}

	public void saveFinalResults() {
		// TODO - implement Ctrls.Ctrl.saveFinalResults
		throw new UnsupportedOperationException();
	}

	public static void saveHighScore(Player player, Date gameDate, boolean jdbc, boolean nosql){
		Entry entry = new Entry(player.getCurrentScore(),gameDate,player);
		if(jdbc){
			PersistKit persistKit = new JdbcKit();
			HighScore highScore = persistKit.makeHighScoreKit();
			highScore.save(entry);
		}
		if(nosql){
			PersistKit persistKit = new NoSQLKit();
			HighScore highScore = persistKit.makeHighScoreKit();
			highScore.save(entry);
		}
	}
}