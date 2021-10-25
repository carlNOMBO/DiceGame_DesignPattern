package Core;

import utilities.StrategyChoices;

import java.time.LocalDateTime;
import java.util.*;

public class DiceGame {

	private List<Player> players;
	private Dice dice1;
	private Dice dice2;
	private Date date;

	private static class DiceGameHolder
	{
		// Instance unique non préinitialisée
		private final static DiceGame instance = new DiceGame();
	}

	private DiceGame() {
		this.dice1 = new Dice(1);
		this.dice2 = new Dice(2);
		this.date = new Date();
	}

	public void start(List<Player> pls, Observer dice1, Observer dice2, Observer strokesTableView) {
		this.players = pls;

		this.dice1.addObserver(dice1);
		this.dice2.addObserver(dice2);


		ScoreHistoryCaretaker.getInstance().addObserver(strokesTableView);
		/*this.dice1.addObserver(gamescene);
		this.dice2.addObserver(gamescene);*/
	}

	public void end() {
		// TODO - implement DiceGame.end
		throw new UnsupportedOperationException();
	}

	public static DiceGame getInstance() {
		// TODO - implement DiceGame.getInstance
		return DiceGameHolder.instance;
	}

	/**
	 * 
	 * @param player
	 */
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void rollDices(String strategy, String name){

		ThrowStrategy strategy1 = null, strategy2=null;

		switch (strategy){
			case "BLOW":
				strategy1 = new Blow();
				strategy2 = new Blow();
				break;

			case "HANDDOWN":
				strategy1 = new ThrowHandDown();
				strategy2 = new ThrowHandDown();
				break;

			case "HANDUP":
				strategy1 = new ThrowHandUp();
				strategy2 = new ThrowHandUp();
				break;
		}

		this.dice1.roll(strategy1);
		this.dice2.roll(strategy2);
System.out.println("DiceGame "+this.players.get(0).getName()+" Strategie : "+strategy+" score : "+(this.dice1.getValeurVisible()+this.dice2.getValeurVisible()));

		for (int i = 0; i<this.players.size(); i++){
			if(this.players.get(i).getName().equals(name)) {
				//System.out.println("Tesssssssssssss");

				if(this.dice1.getValeurVisible()+this.dice2.getValeurVisible() == 7)
					this.players.get(i).addToCurrentScore(10);
				ScoreHistoryCaretaker.getInstance().saveMemento(this.players.get(i).createMemento());
			}
		}

	}
}