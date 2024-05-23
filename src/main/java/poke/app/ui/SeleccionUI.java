package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.service.PokemonService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

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
    private Image foto;

    public SeleccionUI() {

        chico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        chica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
        try {
            // Cargar la imagen desde la URL
            URL url = new URL(PokemonService.urlSpritePokemon("pikachu"));
            ImageIcon icon = new ImageIcon(url);
            p1.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void main(JFrame frame) {
        frame.setContentPane(new SeleccionUI().pMain);
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
