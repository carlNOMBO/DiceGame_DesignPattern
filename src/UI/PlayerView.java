package UI;

import Core.Player;
import utilities.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PlayerView extends JLabel implements Observer {
    private JPanel pnl_main;
    private JLabel lbl_name;
    private JLabel lbl_turn;
    private JLabel lbl_currentscore;
    private String playerName;
    private int currentScore;

    public PlayerView(String playerName) throws HeadlessException {
        //this.lbl_name.setText(playerName);
        //this.setContentPane(this.pnl_main);
        this.playerName = playerName;
        this.currentScore = 0;
        this.setText(this.playerName+"  score : "+this.currentScore);
        this.setVisible(true);
        this.setSize(50,50);
        System.out.println("nom : "+this.getText());
    }

    @Override
    public void update(Observable observable, Object o) {
        int score = (int) o;
        this.currentScore = score;
        this.setText(this.playerName+"  score : "+this.currentScore);
        System.out.println("nom : "+this.getText()+" score : "+score);
    }

    public JLabel getLbl_name() {
        return lbl_name;
    }

    public JLabel getLbl_currentscore() {
        return lbl_currentscore;
    }
}