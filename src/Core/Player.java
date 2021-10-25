package Core;

import utilities.*;

import java.util.Observable;

public class Player extends Observable {

	private String name;
	private int currentScore = 0;
	private boolean marked = false;

	public Player() {
	}

	public Player(String name) {
		this.name = name;
	}

	public int getCurrentScore() {
		return this.currentScore;
	}

	public void addToCurrentScore(int currentScore) {
		this.currentScore += currentScore;
		super.setChanged();
		super.notifyObservers(this.currentScore);
		marked=true;
	}



	public ScoreHistoryMemento createMemento() {
		int coup = this.marked ? 10 : 0;
		this.marked = false;
		return new ScoreHistoryMemento(coup,this.name);
	}

	public void save() {
		// TODO - implement Player.save
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void findByName(String name) {
		// TODO - implement Player.findByName
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	@Override
	public String toString() {
		return "Player{" +
				"name='" + name + '\'' +
				", currentScore=" + currentScore +
				", marked=" + marked +
				'}';
	}
}