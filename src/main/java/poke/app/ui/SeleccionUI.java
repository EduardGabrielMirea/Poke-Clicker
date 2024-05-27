package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.LoginController;
import poke.app.entity.Pokemon;
import poke.app.repository.LoginRepository;
import poke.app.service.PokemonService;
import poke.app.service.RandomStarter;
import poke.app.service.UIService;
import poke.app.entity.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class SeleccionUI extends JFrame{

    private final LoginController loginController;
    private final LoginRepository loginRepository;
    int opcionPersonaje = 0;

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
    private String username;
    public SeleccionUI(LoginController loginController,LoginRepository loginRepository) {
        this.loginController = loginController;
        this.loginRepository = loginRepository;


        chico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                chico.setEnabled(true);
                chica.setEnabled(false);
                opcionPersonaje = 1;
            }
        });
        chica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                chica.setEnabled(true);
                chico.setEnabled(false);
                opcionPersonaje = 2;
            }
        });

        continuar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(opcionPersonaje == 1){
                    loginController.setPersona(username,1);
                    System.out.println("metodo 1"+username);
                }else if(opcionPersonaje == 2){
                    loginController.setPersona(username,2);
                    System.out.println("metodo 2"+username);
                }
                SeleccionTab.setSelectedIndex(1);
            }
        });

        SeleccionTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        RandomStarter randomStarter = new RandomStarter();

        String fireStarter = randomStarter.getStarters("fire");
        String waterStarter = randomStarter.getStarters("water");
        String grassStarter = randomStarter.getStarters("grass");

        UIService.mostrarImagenEnBoton(fireStarter,p1);
        UIService.mostrarImagenEnBoton(waterStarter,p2);
        UIService.mostrarImagenEnBoton(grassStarter,p3);

        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(fireStarter);
                UIService.asignarTextoAlabel(String.format("<html>Nombre (id): %s (%s)<br>Tipos: %s<br>Descripción: %s</html>",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(waterStarter);
                UIService.asignarTextoAlabel(String.format("<html>Nombre (id): %s (%s)<br>Tipos: %s<br>Descripción: %s</html>",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(grassStarter);
                UIService.asignarTextoAlabel(String.format("<html>Nombre (id): %s (%s)<br>Tipos: %s<br>Descripción: %s</html>",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
    }

    public void main(JFrame frame) {
        frame.setContentPane(new SeleccionUI(loginController,loginRepository).pMain);
        //Tamaño de pantalla
        Dimension dimension = new Dimension(800,900);
        frame.setMinimumSize(dimension);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println(username);

    }
    public void setName(String nombre) {
        username = nombre;
    }
}
