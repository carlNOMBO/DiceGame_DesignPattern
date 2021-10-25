package Core;

public class ScoreHistoryMemento {

	private int score;
	private String playerName;

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ScoreHistoryMemento(int score, String playerName) {
		this.score = score;
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}