package utilities;

import Core.ScoreHistoryCaretaker;

import java.util.Random;

public class Randomizer {
	Random random;
	private Randomizer() {
		this.random = new Random();
	}

	private static class RandomizerHolder
	{
		// Instance unique non préinitialisée
		private final static Randomizer instance = new Randomizer();
	}
	public int getValue(int testsNumber) {
		int val=0;
		for (int i = 0; i<testsNumber; i++)
			val = this.random.nextInt(7-1)+1;
		//System.out.println("Random : "+val);
		return val;
	}

	public static Randomizer getInstance() {
		return Randomizer.RandomizerHolder.instance;
	}
}