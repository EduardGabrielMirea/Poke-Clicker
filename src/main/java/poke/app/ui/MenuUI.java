package poke.app.ui;

import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.entity.Pokemon;
import poke.app.localData.User;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.PokemonService;
import poke.app.service.UIService;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuUI {
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private MenuController menuController;


    //pokemons
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;

    private JTextArea infoPokemon;
    //pokemons


    //Paneles
    private JPanel texto;
    private JPanel player;
    private JLabel titulo;
    private JLabel Foto;
    private JLabel Nombre;
    private JPanel menuUI;
    private JPanel header;
    private JPanel foot;
    private JPanel izquierdo;
    private JPanel derecho;
    //Paneles

    //Marcos de los pokemons
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    //Fin marcos



    //Botones
    private JButton entrenar;
    private JButton luchar;
    private JButton b1;
    private JButton evolucionar;
    private JButton tiendaButton;
    //Fin Botones






    public MenuUI(AppService appService)
    {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();

        //PONE LA IMAGEN DEL TÍTULO
        menuController.setImageLocal("src/main/resources/img/Poke-Clicker 300x101.png", titulo);

        //MUESTRA EL USUARIO EN MAYÚSCULAS
        Nombre.setText(User.username.toUpperCase());

        //LLAMA AL MÉTODO PARA INSERTAR IMÁGENES EN LAS CASILLAS DE LOS POKEMON
        imagesInPokemonButtons(User.username,equipoController);

        //COMPROBAR SI EL USUARIO ES CHICO O CHICA PARA ELEGIR FOTO DE PERFIL
        if (loginController.getPersonaGenero(User.username)==1)
        {
           menuController.setImageLocal("src/main/resources/img/icons/redPlayer.png",Foto);
        } else if (loginController.getPersonaGenero(User.username)==2)
        {
            menuController.setImageLocal("src/main/resources/img/icons/leafPlayer.png",Foto);
        }

        //LISTENERS DE BOTONES
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //infoPokemon();
            }
        });

        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        b6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        tiendaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                TiendaUI tiendaUI = new TiendaUI();
                tiendaUI.ventanaTienda();
            }
        });
    }

    public void main(JFrame frame) {
        frame.setContentPane(menuUI);
        frame.setVisible(true);
    }

//    //INSERTAR IMAGEN EN LABEL
//    private void imagesInPokemonLabel(String name,JLabel label,EquipoController equipoController)
//    {
//        Equipo equipo = equipoController.getEquipo(login.getId());
//        Login login = loginRepository.findByNombre(name);
//        if(login!=null){
//
//            Equipo equipo = equipoController.getEquipo(login.getId());
//            if(equipo.getP1()==0){
//
//            }
//            UIService.mostrarImagenEnLabelById(equipo.getP1(),label);
//        }
//
//    }

    //INSERTAR IMÁGENES EN BOTONES | SE PODRÍA MOVER A MenuController
    private void imagesInPokemonButtons(String name,EquipoController equipoController)
    {
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

    private void infoPokemon(int id,int idPokemon){
        Login login = loginRepository.findByNombre(User.username);
        if(login!=null){

            Equipo equipo = equipoController.getEquipo(login.getId());
            if(equipo.getP2()==0){
                Pokemon p = PokemonService.getPokemon(id);
                UIService.asignarTextoAJTextArea(String.format("Nombre (id): %s (%s)\nTipos: %s\nDescripción: %s",p.name,p.id,p.getTipos(p),PokemonService.getDescription(p.name)),infoPokemon);
            }

        }
    }

}
