package Core;

import java.util.Date;

public class Entry {

	private int score;
	private Player player;
	private Date gameDate;

	/**
	 * 
	 * @param score
	 * @param gameDate
	 * @param player
	 */
	public Entry(int score, Date gameDate, Player player) {
		this.score = score;
		this.player = player;
		this.gameDate = gameDate;
	}

	public void save() {
		// TODO - implement Entry.save
		throw new UnsupportedOperationException();
	}

	public Entry[] findAll() {
		// TODO - implement Entry.findAll
		throw new UnsupportedOperationException();
	}

	public void delete() {
		// TODO - implement Entry.delete
		throw new UnsupportedOperationException();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	@Override
	public String toString() {
		return "Entry{" +
				"score=" + score +
				", player=" + player +
				", gameDate=" + gameDate +
				'}';
	}
}