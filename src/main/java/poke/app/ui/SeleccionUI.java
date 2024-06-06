package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.config.AppConfig;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.entity.Equipo;
import poke.app.entity.Pokemon;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.PokemonService;
import poke.app.service.RandomStarter;
import poke.app.service.UIService;
import poke.app.entity.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class SeleccionUI{

    private LoginController loginController;
    private LoginRepository loginRepository;
    private EquipoRepository equipoRepository;
    private EquipoController equipoController;
    private AppConfig appConfig;
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

    public SeleccionUI(AppService appService) {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.appConfig = appService.getAppConfig();

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
                UIService.asignarTextoAJTextArea(String.format("Nombre (id): %s (%s)\nTipos: %s\nDescripción: %s",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(waterStarter);
                seleccionInicial = p.id;
                UIService.asignarTextoAJTextArea(String.format("Nombre (id): %s (%s)\nTipos: %s\nDescripción: %s",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),informacion);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pokemon p = PokemonService.getPokemon(grassStarter);
                seleccionInicial = p.id;
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
                Equipo equipoInicial = new Equipo(login.getId(),seleccionInicial);
                equipoInicial.setN1(1);
                equipoRepository.save(equipoInicial);
                MenuUI menuUI = new MenuUI(appService);
                menuUI.initUI(appService.getAppConfig().jFrame(Window.frame));
            }
        });
    }
    // Métodos setters para inyectar dependencias
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setLoginRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void setEquipoController(EquipoController equipoController) {
        this.equipoController = equipoController;
    }

    public void setEquipoRepository(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void initUI(JFrame frame) {

        //frame.setContentPane(new SeleccionUI().pMain);
        frame.setContentPane(SeleccionTab);
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
