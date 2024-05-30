package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.entity.Equipo;
import poke.app.entity.Pokemon;
import poke.app.localData.User;
import poke.app.repository.EquipoRepository;
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
    private final EquipoRepository equipoRepository;
    private final EquipoController equipoController;
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
    private JTextArea informacion;
    private Image foto;
    private String username;
    private int seleccionInicial;
    private int nivelInicial;

    public SeleccionUI(LoginController loginController,LoginRepository loginRepository,EquipoRepository equipoRepository,EquipoController equipoController, JFrame frame) {
        this.loginController = loginController;
        this.loginRepository = loginRepository;
        this.equipoController = equipoController;
        this.equipoRepository = equipoRepository;


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
                seleccionInicial = p.id;
                nivelInicial = 1;
                UIService.asignarTextoAJTextArea(String.format("Nombre (id): %s (%s)\nTipos: %s\nDescripción: %s",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(waterStarter);
                seleccionInicial = p.id;
                nivelInicial = 1;
                UIService.asignarTextoAJTextArea(String.format("Nombre (id): %s (%s)\nTipos: %s\nDescripción: %s",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(grassStarter);
                seleccionInicial = p.id;
                nivelInicial = 1;
                UIService.asignarTextoAJTextArea(String.format("Nombre (id): %s (%s)\nTipos: %s\nDescripción: %s",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        pfin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(opcionPersonaje == 1){
                    loginController.setPersona(User.username,1);
                }else if(opcionPersonaje == 2){
                    loginController.setPersona(User.username,2);
                }
                Login login = loginRepository.findByNombre(User.username);
                Equipo equipo = new Equipo(login.getId(),seleccionInicial,nivelInicial);
                Menu menu = new Menu(loginController,loginRepository,equipoController,equipoRepository);
                menu.main(frame);
            }
        });
    }

    public void main(JFrame frame) {
        frame.setContentPane(new SeleccionUI(loginController,loginRepository,equipoRepository,equipoController, frame).pMain);
        //Tamaño de pantalla
        Dimension dimension = new Dimension(800,900);
        frame.setMinimumSize(dimension);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println(username);

    }
}
