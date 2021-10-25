package Persist;

import Core.*;

public class JdbcKit implements PersistKit {

	public HighScore makeHighScoreKit() {
		return new HighScoreMySQL("jdbc:mysql://localhost:3306/dicegame","","");
	}

	public Entry makeEntryKit() {
		// TODO - implement JdbcKit.makeEntryKit
		throw new UnsupportedOperationException();
	}

	public JdbcKit() {
	}

	public static void main(String[] args){

		HighScore highScore = (new JdbcKit()).makeHighScoreKit();
		highScore.save(new Entry(878,null,new Player("Aaron")));
		highScore.save(new Entry(964,null,new Player("Fanchardy")));
	}
}
