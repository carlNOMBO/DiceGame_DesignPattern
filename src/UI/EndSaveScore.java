package UI;

import Core.Player;
import Ctrls.Ctrl;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.util.List;

public class EndSaveScore extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lbl_msg;
    private JCheckBox cbx_mysql;
    private JCheckBox cbx_mongo;
    private List<Player> players;
    private Date date;

    public EndSaveScore(List<Player> players, Date date) {
        this.players = players;
        this.date = date;
        System.out.println("EndSaveScore sauvegarde");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        lbl_msg.setText("Le meilleur score est : "+this.getBestPlayer().getCurrentScore()+"--"+this.getBestPlayer().getName()+"\nSauvegarder ??");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(getBestPlayer());
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        players.forEach(player -> {System.out.println(player.getName());});
    }

    private void onOK(Player bestPlayer) {

        Ctrl.saveHighScore(bestPlayer,this.date,cbx_mysql.isSelected(),cbx_mongo.isSelected());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public Player getBestPlayer(){
        Player bestPlayer = this.players.get(0);
        for (int i = 1; i<this.players.size(); i++){
            if(bestPlayer.getCurrentScore() < this.players.get(i).getCurrentScore()){
                bestPlayer = this.players.get(i);
            }
        }
        return bestPlayer;
    }

    public static void main(String[] args) {
        EndSaveScore dialog = new EndSaveScore(null, new Date());
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
