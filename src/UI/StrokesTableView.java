package UI;

import Core.ScoreHistoryCaretaker;
import Core.ScoreHistoryMemento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Observer;

public class StrokesTableView extends JTable implements Observer {
    private DefaultTableModel tableModel;

    public StrokesTableView(DefaultTableModel tableModel) {
        super(tableModel);
        this.tableModel = tableModel;
        /*this.tableModel.addColumn("Joueur");
        this.tableModel.addColumn("Coup");*/
        this.setSize(50,50);
        this.setVisible(true);
        this.tableModel.insertRow(this.tableModel.getRowCount(), new Object[] { "Joueur","Score" });
    }

    @Override
    public void update(java.util.Observable observable, Object o) {

            ScoreHistoryMemento m = (ScoreHistoryMemento)o;
            this.tableModel.insertRow(this.tableModel.getRowCount(), new Object[] { m.getPlayerName(),m.getScore() });
            //System.out.println("Tableview GameScene "+m.getPlayerName()+" coup : "+m.getScore());
    }
}