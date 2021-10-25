package UI;

import Core.Dice;
import Core.Player;
import Core.ScoreHistoryCaretaker;
import Core.ScoreHistoryMemento;
import Ctrls.Ctrl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GameScene extends JFrame {
    private JLabel lbl_gameTitle;
    private JPanel pnl_mainscen;
    private JPanel pnl_strokesHistory;
    private JTable tbl_strokesHistory;
    private JPanel pnl_playersView;
    private JPanel pnl_dicesView;
    private JButton btn_roll;
    private JComboBox cbb_strategy;
    private JPanel pnl_main;
    private JLabel lbl_currentPlayer;
    private JPanel pnl_diceView1;
    private JPanel pnl_diceView2;

    private DiceView diceView1;
    private DiceView diceView2;
    private StrokesTableView strokesTableView;
    private DefaultTableModel tableModel;

    private List<Player> players;
    private List<Observer> playerViews;

    private int turn = 0;

    public GameScene(List<Player> players) {

        this.diceView1 = new DiceView(1);
        this.diceView2 = new DiceView(2);
        this.diceView1.setFont(this.diceView1.getFont().deriveFont(32.0f));
        this.diceView2.setFont(this.diceView2.getFont().deriveFont(32.0f));

        this.playerViews = new LinkedList<Observer>();
        this.players = players;

        pnl_dicesView.setLayout(new FlowLayout());
        pnl_diceView1.setLayout(new CardLayout());
        pnl_diceView2.setLayout(new CardLayout());
        pnl_diceView1.add(this.diceView1,"Dé 1");
        pnl_diceView2.add(this.diceView2,"Dé 2");

        pnl_playersView.setLayout(new FlowLayout());
        players.forEach(player -> {
            PlayerView playerView = new PlayerView(player.getName());
            this.playerViews.add(playerView);
            pnl_playersView.add(playerView);
        });
        Iterator<Player> plsIt = this.players.iterator();

        this.tableModel = new DefaultTableModel();
        this.tbl_strokesHistory = new JTable(this.tableModel);
        this.tableModel.addColumn("Joueur");
        this.tableModel.addColumn("Coup");
        this.strokesTableView = new StrokesTableView(this.tableModel);

        this.pnl_strokesHistory.setLayout(new CardLayout());
        this.pnl_strokesHistory.setAutoscrolls(true);
        this.pnl_strokesHistory.add(this.strokesTableView);

        this.setContentPane(this.pnl_main);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        //this.lbl_currentPlayer.setText(players.get(0).getName());

        JFrame ThisFrame = this;
        btn_roll.addActionListener(new ActionListener() {
            private Iterator<Player> itInPls=players.iterator();

            {lbl_currentPlayer.setText(itInPls.next().getName());}
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(turn>9){
                    EndSaveScore dialog = new EndSaveScore(players,new Date());
                    dialog.pack();
                    dialog.setVisible(true);
                    //Closing game
                    ThisFrame.dispose();
                    System.out.println("GameScene : fin de partie");
                }
                System.out.println("GameScene : fin de partie : "+turn);
                Ctrl.rollDices(cbb_strategy.getSelectedItem().toString(),lbl_currentPlayer.getText());

                if(itInPls.hasNext()) {
                    lbl_currentPlayer.setText(itInPls.next().getName());
                }
                else{
                    itInPls = players.iterator();
                    lbl_currentPlayer.setText(itInPls.next().getName());
                    turn++;
                    System.out.println("GameScene : turn "+turn);
                }
            }
        });
    }

    public void consulterScore() {
        // TODO - implement IHM.consulterScore
        throw new UnsupportedOperationException();
    }

    public void saveFinalResults() {
        // TODO - implement IHM.saveFinalResults
        throw new UnsupportedOperationException();
    }

    public DiceView getDiceView1() {
        return diceView1;
    }

    public DiceView getDiceView2() {
        return diceView2;
    }

    public List<Observer> getPlayerViews() {
        return playerViews;
    }

    public StrokesTableView getStrokesTableView() {
        return strokesTableView;
    }

    public void setStrokesTableView(StrokesTableView strokesTableView) {
        this.strokesTableView = strokesTableView;
    }

}
