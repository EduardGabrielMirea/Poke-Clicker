package poke.app.ui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionUI extends JFrame{

    private JLabel Chico;
    private JLabel Chica;
    private JTabbedPane SeleccionTab;
    private JLabel seleccionaElPersonajeQueLabel;

    public SeleccionUI(){

        Chica.addMouseListener(new MouseAdapter() {
            //Botón para seleccionar a la chica como pj
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("HOLA CHICA");
                JOptionPane.showMessageDialog(null,"Seleccionada chica");
            }
        });


        Chico.addMouseListener(new MouseAdapter() {
            //Botón para seleccionar al chico como pj
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("HOLA CHICO");
                JOptionPane.showMessageDialog(null,"Seleccionada chico");
            }
        });
    }
}
