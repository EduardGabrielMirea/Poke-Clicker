package poke.app.ui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

@Component
public class SeleccionUI extends JFrame{

    private JLabel Chico;
    private JLabel Chica;
    private JTabbedPane SeleccionTab;
    private JLabel textoPrincipal;
    private JPanel barra1;
    private JPanel barra2;
    private JPanel bg;
    private JPanel pMain;
    private Image foto;

    public void main(JFrame frame) {
        frame.setContentPane(new SeleccionUI().pMain);
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /*public SeleccionUI() {
        setTitle("Seleccion");
        JPanel panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        panel.setLayout(null);
        bg = new JPanel();
        bg.setLayout(null);
        barra1 = new JPanel();
        barra1.setLayout(null);
        barra1.setBackground(Color.WHITE);
        barra1.setBounds(10, 10, 450, 200);
        barra2 = new JPanel();
        barra2.setLayout(null);
        barra2.setBackground(Color.WHITE);
        barra2.setBounds(10, 50, 450, 200);
        barra1.add(barra2);
        //setVisible(true);
    }*/
}
