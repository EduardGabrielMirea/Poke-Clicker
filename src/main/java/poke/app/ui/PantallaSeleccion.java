package poke.app.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PantallaSeleccion {
    private JButton buscarButton;

    public PantallaSeleccion(JFrame frame)
{
    JPanel panel = new JPanel();
    frame.setContentPane(panel);
    panel.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1080, 720);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setTitle("seleccion personaje");

    Border layoutPrincipal = BorderFactory.createLineBorder(Color.black);

    buscarButton = new JButton();
    buscarButton.setIcon(new ImageIcon(getClass().getResource("")));
    buscarButton.setBorderPainted(false);
    buscarButton.setFocusPainted(false);
    buscarButton.setContentAreaFilled(false);

}


}

