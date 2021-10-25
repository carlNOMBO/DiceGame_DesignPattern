package Core;

import utilities.Randomizer;

import java.util.Random;

public class ThrowHandUp implements ThrowStrategy {

	public int throwAlgo() {
		return Randomizer.getInstance().getValue(7);
	}

}