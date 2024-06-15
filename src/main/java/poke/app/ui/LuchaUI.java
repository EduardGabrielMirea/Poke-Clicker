package poke.app.ui;

import poke.app.localData.Window;

import javax.swing.*;

public class LuchaUI {
    private JPanel mainLucha;
    private JPanel panelLucha;
    private JPanel panelEquipo;
    private JPanel pInformacion;
    private JPanel pBotones;

    public void ventanaLucha() {
        JFrame frame = Window.frame;
        frame.setContentPane(new LuchaUI().mainLucha);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
