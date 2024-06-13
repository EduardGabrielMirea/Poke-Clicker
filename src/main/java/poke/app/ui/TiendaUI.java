package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.UIService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


@Component
public class TiendaUI {
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private MenuController menuController;

    private JPanel panelPrincipal;
    private JTabbedPane Tienda;
    private JPanel mejoras;
    private JPanel pokemon;
    private JScrollBar scrollBar1;
    private JPanel derecha;
    private JPanel abajo;
    private JPanel arriba;
   // private JButton p1;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;
    private JLabel p5;
    private JLabel p6;


    public TiendaUI(AppService appService) throws IOException {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();


        //Mostrar Pokemon

        //UIService.mostrarImagenEnJlabelByIdStatico(135,p1);
        //UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP1(),p1);
        UIService.mostrarImagenEnJlabelByIdStatico(134,p2);
        UIService.mostrarImagenEnJlabelByIdStatico(133,p3);
        UIService.mostrarImagenEnJlabelByIdStatico(136,p4);
        UIService.mostrarImagenEnJlabelByIdStatico(132,p5);
        UIService.mostrarImagenEnJlabelByIdStatico(131,p6);

        //UIService.most(12,p1);
        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Hola");
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void ventanaTienda() {
        JFrame frame = Window.frame;
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Equipo getEquipoByNameUser(String name) {
        Login login = loginRepository.findByNombre(name);
        if (login != null) {
            return equipoController.getEquipo(login.getId());
        }else{
            return null;
        }
    }
}
