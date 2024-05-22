package poke.app.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PantallaSeleccion {
    private JButton buscarButton;

    public PantallaSeleccion(JFrame frame)
{
    Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/img/icono.png");
    JPanel panel = new JPanel();
    frame.setContentPane(panel);
    frame.setIconImage(icon);
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

