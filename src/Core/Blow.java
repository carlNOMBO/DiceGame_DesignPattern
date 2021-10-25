package Core;

import utilities.Randomizer;

public class Blow implements ThrowStrategy {

	public int throwAlgo() {
		return Randomizer.getInstance().getValue(21);
	}
}