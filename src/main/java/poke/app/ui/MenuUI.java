package poke.app.ui;

import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.UIService;
import javax.swing.*;

public class MenuUI{
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private JPanel menuUI;
    private JPanel header;
    private JPanel foot;
    private JPanel izquierdo;
    private JPanel derecho;

    //pokemons
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    //pokemons


    private JPanel texto;
    private JPanel player;
    private JLabel titulo;
    private JLabel Foto;
    private JLabel Nombre;

    //Marcos de los pokemons
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;

    private JButton entrenar;
    private JButton luchar;
    private JButton b1;
    private MenuController menuController;



    public MenuUI(AppService appService)
    {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();

        menuController.setImageLocal("src/initUI/resources/img/Poke-Clicker 300x101.png", titulo);
        Nombre.setText(User.username.toUpperCase());

        imagesInPokemonButtons(User.username,equipoController);

        if (loginController.getPersonaGenero(User.username)==1)
        {
           menuController.setImageLocal("src/initUI/resources/img/icons/redPlayer.png",Foto);
        } else if (loginController.getPersonaGenero(User.username)==2)
        {
            menuController.setImageLocal("src/initUI/resources/img/icons/leafPlayer.png",Foto);
        }

    }

    public void initUI(JFrame frame) {
        frame.setContentPane(menuUI);
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void imagesInPokemonButtons(String name,EquipoController equipoController){
        //Cambiar luego de refactorizar y unir las tablas bien
        Login login = loginRepository.findByNombre(name);
        if(login!=null){

            Equipo equipo = equipoController.getEquipo(login.getId());
            if(equipo.getP1()==0){

            }
            UIService.mostrarImagenEnBotonById(equipo.getP1(),b1);
            UIService.mostrarImagenEnBotonById(equipo.getP2(),b2);
            UIService.mostrarImagenEnBotonById(equipo.getP3(),b3);
            UIService.mostrarImagenEnBotonById(equipo.getP4(),b4);
            UIService.mostrarImagenEnBotonById(equipo.getP5(),b5);
            UIService.mostrarImagenEnBotonById(equipo.getP6(),b6);
        }

    }

}