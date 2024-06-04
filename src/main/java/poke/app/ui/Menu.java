package poke.app.ui;

import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.localData.User;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.PokemonService;
import poke.app.service.UIService;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu {
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private JPanel menu;
    private JPanel header;
    private JPanel foot;
    private JPanel izquierdo;
    private JPanel derecho;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    private JPanel texto;
    private JPanel player;
    private JLabel titulo;
    private JLabel Foto;
    private JLabel Nombre;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton entrenar;
    private JButton luchar;
    private JButton b1;
    private MenuController menuController;

    public Menu(LoginController loginController, LoginRepository loginRepository, EquipoController equipoController, EquipoRepository equipoRepository)
    {
        this.loginController = loginController;
        this.loginRepository = loginRepository;
        this.equipoController = equipoController;
        this.equipoRepository = equipoRepository;
        this.menuController = new MenuController();

        menuController.setImageLocal("src/main/resources/img/Poke-Clicker 300x101.png", titulo);
        Nombre.setText(User.username.toUpperCase());

        imagesInPokemonButtons(User.username,equipoController);

        if (loginController.getPersonaGenero(User.username)==1)
        {
           menuController.setImageLocal("src/main/resources/img/icons/redPlayer.png",Foto);
        } else if (loginController.getPersonaGenero(User.username)==2)
        {
            menuController.setImageLocal("src/main/resources/img/icons/leafPlayer.png",Foto);
        }

    }



    public void main(JFrame frame) {
        frame.setContentPane(new Menu(loginController, loginRepository,equipoController, equipoRepository).menu);
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void imagesInPokemonButtons(String name,EquipoController equipoController){

        Equipo equipo = equipoController.getEquipo(6L);
        UIService.mostrarImagenEnBotonById(equipo.getP1(),b1);
        UIService.mostrarImagenEnBotonById(equipo.getP2(),b2);
        UIService.mostrarImagenEnBotonById(equipo.getP3(),b3);
        UIService.mostrarImagenEnBotonById(equipo.getP4(),b4);
        UIService.mostrarImagenEnBotonById(equipo.getP5(),b5);
        UIService.mostrarImagenEnBotonById(equipo.getP6(),b6);
    }

}
