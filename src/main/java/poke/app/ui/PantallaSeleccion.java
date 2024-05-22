package poke.app.ui;
import java.awt.*;
import javax.swing.*;
public class PantallaSeleccion {


    public PantallaSeleccion(JFrame frame)
{
    JPanel panel = new JPanel();
    frame.setContentPane(panel);
    panel.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1920, 1080);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setTitle("seleccion personaje");
}


}

