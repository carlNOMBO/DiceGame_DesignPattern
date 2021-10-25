package UI;

import Core.Player;
import Ctrls.Ctrl;

import javax.swing.*;
import java.awt.*;

public class IHM extends JFrame {
	private DiceView diceView1;
	private DiceView diceView2;

	public IHM() {
		super("Jeu de dés");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700,500);
		this.setLocationRelativeTo(null);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(new JButton("Jouer"));
		contentPane.add(new JButton("Consulter score"));
	}

	public void consulterScore() {
		// TODO - implement IHM.consulterScore
		throw new UnsupportedOperationException();
	}

	public void saveFinalResults() {
		// TODO - implement IHM.saveFinalResults
		throw new UnsupportedOperationException();
	}

}