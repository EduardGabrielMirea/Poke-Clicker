package poke.app.ui;

import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.EvolucionesRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

import javax.swing.*;

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

    public LuchaUI(AppService appService) {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();
        this.evolucionesRepository = appService.getEvolucionesRepository();
    }

    public void ventanaLucha() {
        JFrame frame = Window.frame;
        frame.setContentPane(mainLucha);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
