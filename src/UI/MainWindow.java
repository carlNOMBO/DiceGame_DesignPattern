package UI;

import Core.Dice;
import Core.Player;
import Ctrls.Ctrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainWindow extends JFrame{
    private JLabel lb_title;
    private JButton btn_play;
    private JButton btn_consultScores;
    private JPanel pnl_body;
    private JPanel pnl_main;

    public MainWindow() {
        this.setContentPane(this.pnl_main);
        this.setTitle("Jeu de dés");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);

        btn_play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*Player p1 = new Player("Aaron");
                Player p2 = new Player("Carl");*/
                List<Player> players = new LinkedList<Player>();
                players.add(new Player("Fanchardy"));
                players.add(new Player("NOMBO"));


                GameScene gameScene = new GameScene(players);

                for (int i=0; i<players.size(); i++){
                    players.get(i).addObserver(gameScene.getPlayerViews().get(i));
                }

                Ctrl.play(players,gameScene.getDiceView1(),
                        gameScene.getDiceView2(),gameScene.getStrokesTableView());

            }
        });
    }
}
