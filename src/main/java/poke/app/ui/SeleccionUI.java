package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.service.UIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class SeleccionUI extends JFrame{

    private JTabbedPane SeleccionTab;
    private JPanel barra1;
    private JPanel barra2;
    private JPanel bg;
    private JPanel pMain;
    private JButton chico;
    private JButton chica;
    private JButton continuar1;
    private JButton pfin;
    private JButton p1;
    private JButton p2;
    private JButton p3;
    private JPanel arribaPokemon;
    private JPanel abajoPokemon;
    private JPanel arribaPersonaje;
    private JPanel abajoPersonaje;
    private JPanel Ptexto;
    private JLabel textoPJ;
    private JPanel contenedorImagenes;
    private JPanel ConChico;
    private JPanel ConChica;
    private JPanel medioPokemon;
    private JLabel informacion;
    private Image foto;

    public SeleccionUI() {

        chico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                chico.setEnabled(true);
                chica.setEnabled(false);
            }
        });
        chica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                chica.setEnabled(true);
                chico.setEnabled(false);
            }
        });
        continuar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SeleccionTab.setSelectedIndex(1);
            }
        });

        SeleccionTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        UIService.mostrarImagenEnBoton("charmander",p1);
        UIService.mostrarImagenEnBoton("Squirtle",p2);
        UIService.mostrarImagenEnBoton("BULBASAUR",p3);

        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //NO HACE SALTO DE LÍNEA
                UIService.asignarTextoAlabel(String.format("%s\n%s\n%s","Pokemon 1","Charmander","ESTO ES UNA PRUEBA"),informacion);
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //NECESITAS HTML PARA HACER SALTOS DE LÍNEA... O TAMBIÉN UN JTEXTAREA
                UIService.asignarTextoAlabel("<html>Pokemon 2<br>Squirtle<br>A VER SI FUNCA</html>",informacion);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                UIService.asignarTextoAlabel("Pokemon 3\nBulbasaur\nREMPLAZAR LUEGO CON INFO DE LA API",informacion);
            }
        });
    }

    public void main(JFrame frame) {
        frame.setContentPane(new SeleccionUI().pMain);
        //Tamaño de pantalla
        Dimension dimension = new Dimension(800,900);
        frame.setMinimumSize(dimension);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
