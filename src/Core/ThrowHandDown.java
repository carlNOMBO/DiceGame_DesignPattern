package Core;

import utilities.Randomizer;

public class ThrowHandDown implements ThrowStrategy {

	public int throwAlgo() {
		return Randomizer.getInstance().getValue(14);
	}

}