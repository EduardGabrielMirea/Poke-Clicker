package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.localData.Window;

import javax.swing.*;


@Component
public class TiendaUI {
    private JPanel panelPrincipal;
    private JTabbedPane Tienda;
    private JPanel mejoras;
    private JPanel pokemon;
    private JScrollBar scrollBar1;
    private JPanel derecha;
    private JPanel abajo;
    private JPanel arriba;


    public void ventanaTienda() {
        JFrame frame = Window.frame;
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
