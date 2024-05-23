package poke.app.ui;

import org.springframework.stereotype.Component;
import testing.PokemonSpriteFetcher;
import testing.Testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

@Component
public class SeleccionUI extends JFrame{

    private JTabbedPane SeleccionTab;
    private JLabel textoPrincipal;
    private JPanel barra1;
    private JPanel barra2;
    private JPanel bg;
    private JPanel pMain;
    private JButton chico;
    private JButton chica;
    private JButton continuar1;
    private JButton fireStarter;
    private JButton waterStarter;
    private JButton grassStarter;
    private Icon starter;
    private int personaje;
    private String pokemonName;
     Testing testing = new Testing();
     PokemonSpriteFetcher pokemonSpriteFetcher = new PokemonSpriteFetcher();
    public SeleccionUI() throws IOException {
        chico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                personaje = 1;
            }
        });
        chica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                personaje = 2;
            }
        });
        continuar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SeleccionTab.setSelectedIndex(1);
                System.out.println(personaje);
                testing.randomStarter("fire");
            }
        });

        SeleccionTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        //Tras haber seleccionado el personaje

        pokemonName = testing.randomStarter("fire");
        fireStarter.setIcon(pokemonSpriteFetcher.getPokemonSpriteIcon(pokemonName));
    }

    public void main(JFrame frame) throws IOException {
        frame.setContentPane(new SeleccionUI().pMain);
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
