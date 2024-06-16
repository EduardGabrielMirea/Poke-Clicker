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
    private JPanel panelScrollBar2;
    private JPanel equipoPokemon;
    private JScrollPane equipoPokemonScroll;
    private JPanel panelScrollBar1;
    private JButton comprar;
    private JButton evolucionar;
    private JButton salir;


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

        //Listeners pestaña Equipo
        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesEvoluciona();
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesEvoluciona();
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesEvoluciona();
            }
        });
        p4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesEvoluciona();
            }
        });
        p5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesEvoluciona();
            }
        });
        p6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesEvoluciona();
            }
        });
        /*MouseAdapter evoluciona = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(suficienteDinero(true,false)){
                    evolucionar.setEnabled(true);
                }
                comprar.setEnabled(false);
            }
        };*/

        //Listeners Pokemon Shop
        ps1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        ps8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });
        /*MouseAdapter compra = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(suficienteDinero(false,true)){
                    comprar.setEnabled(true);
                }
                evolucionar.setEnabled(false);
            }
        };
        ps1.addMouseListener(compra);
        ps2.addMouseListener(compra);
        ps3.addMouseListener(compra);
        ps4.addMouseListener(compra);
        ps5.addMouseListener(compra);
        ps6.addMouseListener(compra);
        ps7.addMouseListener(compra);
        ps8.addMouseListener(compra);*/

        //Botones de la tienda
        comprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        evolucionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MenuUI menuUI = new MenuUI(appService);
                menuUI.main(Window.frame);
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

    private Equipo getEquipoByNameUser(String name) {
        Login login = loginRepository.findByNombre(name);
        if (login != null) {
            return equipoController.getEquipo(login.getId());
        }else{
            return null;
        }
    }


    private boolean suficienteDinero(boolean evolucion,boolean compra){
        Login login = loginRepository.findLoginById(User.id);
        if(login != null){
            if(compra){
                if(login.getPokemonedas() >= 10){
                    return true;
                }
            }else if(evolucion){
                if(login.getPokemonedas() >= 50){
                    return true;
                }
            }
        }
        return false;
    }

    private void botonesEvoluciona(){
        if(suficienteDinero(true,false)){
            evolucionar.setEnabled(true);
        }
        comprar.setEnabled(false);
    }

    private void botonesCompra(){
        if(suficienteDinero(false,true)){
            comprar.setEnabled(true);
        }
        evolucionar.setEnabled(false);
    }
}
