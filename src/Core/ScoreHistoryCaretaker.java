package Core;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

public class ScoreHistoryCaretaker extends Observable {
	private List<ScoreHistoryMemento> strokesHistory;

	private static class ScoreHistoryCaretakerHolder
	{
		// Instance unique non préinitialisée
		private final static ScoreHistoryCaretaker instance = new ScoreHistoryCaretaker();
	}

	private ScoreHistoryCaretaker() {
		this.strokesHistory = new LinkedList<ScoreHistoryMemento>();
	}

	public void saveMemento(ScoreHistoryMemento m) {
		//System.out.println("Adding to story data : "+m.getPlayerName()+" "+m.getScore());
		this.strokesHistory.add(m);
		super.setChanged();
		super.notifyObservers(m);
	}

	public ScoreHistoryMemento retrieveMemento() {
		return this.strokesHistory.remove(0);
	}

	public static ScoreHistoryCaretaker getInstance() {
		return ScoreHistoryCaretakerHolder.instance;
	}

}