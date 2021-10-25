import Core.Player;
import Ctrls.Ctrl;
import UI.IHM;
import UI.MainWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Application {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        /*Player p1 = new Player("Carl");
        Ctrl.play(p1);*/
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MainWindow mainWindow = new MainWindow();
        //IHM ihm = new IHM();
    }
}
