package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.localData.PokemonList;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.UIService;

import javax.swing.*;
import java.awt.*;
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
    private JLabel ps1;
    private JLabel ps2;
    private JLabel ps3;
    private JLabel ps4;
    private JLabel ps5;
    private JLabel ps6;
    private JLabel ps7;
    private JLabel ps8;
    private JScrollPane Pokemon;


    public TiendaUI(AppService appService) throws IOException {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();


        //Mostrar Pokemon del equipo en tienda
        if(User.id != null){
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP1(),p1);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP2(),p2);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP3(),p3);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP4(),p4);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP5(),p5);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP6(),p6);
        }

        //Tienda Pokemon con scrollbar
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps1);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps2);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps3);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps4);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps5);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps6);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps7);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs),ps8);


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
