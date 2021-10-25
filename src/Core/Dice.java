package Core;

import utilities.*;

import java.util.Observable;

public class Dice extends Observable {

	private int valeurVisible = 1;
	private int number;

	public int getValeurVisible() {
		return this.valeurVisible;
	}

	public void setValeurVisible(int valeurVisible) {

		this.valeurVisible = valeurVisible;
		super.setChanged();
		super.notifyObservers(String.valueOf(valeurVisible));
	}

	public Dice() {
	}

	public Dice(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	/**
	 * 
	 * @param throwStrategy
	 */
	public void roll(ThrowStrategy throwStrategy) {
		int val = throwStrategy.throwAlgo();
		System.out.println("Dice "+this.number+" Roll : "+val);
		this.setValeurVisible(val);
	}

}