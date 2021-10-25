package UI;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class DiceView extends JLabel implements Observer {

	private JLabel lbl_displayValue;
	private JPanel pnl_main;
	final private String text;

	private int number;

	public DiceView(int number) throws HeadlessException {
		super();
		this.number = number;
		this.text = "Dé "+number+": ";
		this.setText(this.text);
		this.setVisible(true);
		this.setSize(50,50);
		//System.out.println("Diceview nom : Dé "+number+" valeur : "+this.getText());
	}

	@Override
	public void update(Observable observable, Object o) {
		String value = (String)o;
		this.setText(this.text+value);
		//System.out.println("Diceview nom : Dé "+this.number+" valeur : "+value);
	}
}