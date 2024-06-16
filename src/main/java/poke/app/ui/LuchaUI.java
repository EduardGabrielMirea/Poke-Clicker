package poke.app.ui;

import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.localData.PokemonList;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.EvolucionesRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.PokemonService;
import poke.app.service.RandomStarter;
import poke.app.service.UIService;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class LuchaUI {
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private MenuController menuController;
    private EvolucionesRepository evolucionesRepository;

    private JPanel mainLucha;
    private JPanel panelLucha;
    private JPanel panelEquipo;
    private JPanel pInformacion;
    private JPanel pBotones;
    private JProgressBar hpEnemigo;
    private JLabel enemigo;
    private JPanel panelEnemigo;
    private JLabel pokemon;
    private JButton bVolver;
    private Random random = new Random();
    public LuchaUI(AppService appService) throws IOException {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();
        this.evolucionesRepository = appService.getEvolucionesRepository();

        hpEnemigo.setValue(100);

        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.minionIDs),enemigo);
        UIService.mostrarImagenEnJlabelByIdStatico(PokemonList.pokemonElegido,pokemon);

        bVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MenuUI menuUI = new MenuUI(appService);
                menuUI.main(Window.frame);
            }
        });
        enemigo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                hpEnemigo.setValue(hpEnemigo.getValue()-10);
                if(hpEnemigo.getValue() <= 0){
                    Login login = loginRepository.findLoginById(User.id);
                    int randomWin = random.nextInt(20)+1;
                    if(login!=null){
                        login.setPokemonedas(login.getPokemonedas()+randomWin);
                        loginRepository.save(login);
                        JOptionPane.showMessageDialog(null,"Haz ganado "+randomWin+" pokemonedas");
                    }

                    MenuUI menuUI = new MenuUI(appService);
                    menuUI.main(Window.frame);
                }

            }
        });
    }

    public void ventanaLucha() {
        JFrame frame = Window.frame;
        frame.setContentPane(mainLucha);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
