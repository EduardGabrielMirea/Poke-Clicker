package poke.app.ui;

import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.entity.Pokemon;
import poke.app.localData.PokemonList;
import poke.app.localData.User;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.ButtonColors;
import poke.app.service.PokemonService;
import poke.app.service.UIService;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

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

    private JTextArea inforPokemon;
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
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    //Fin marcos

    //Botones
    private JButton luchar;
    private JButton cheatMoney;
    private JButton tiendaButton;
    private JLabel informacionPlayer;
    private JLabel informPoke;
    //Fin Botones

    public MenuUI(AppService appService)
    {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();

        //tiendaButton.set

        ButtonColors.setColors(tiendaButton);
        ButtonColors.setColors(cheatMoney);
        ButtonColors.setColors(tiendaButton);
        ButtonColors.setColors(luchar);

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
                infoPokemon(equipoController.getEquipo(User.id).getP1());
            }
        });

        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                infoPokemon(equipoController.getEquipo(User.id).getP2());
            }
        });

        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                infoPokemon(equipoController.getEquipo(User.id).getP3());
            }
        });

        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                infoPokemon(equipoController.getEquipo(User.id).getP4());
            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                infoPokemon(equipoController.getEquipo(User.id).getP5());
            }
        });

        b6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                infoPokemon(equipoController.getEquipo(User.id).getP6());
            }
        });

        tiendaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Hilos
                Thread thread = new Thread(() ->
                {
                    //System.out.println("hilo ejecutado por"+Thread.currentThread().getName());
                    super.mouseClicked(e);
                    TiendaUI tiendaUI = null;
                    try {
                        tiendaUI = new TiendaUI(appService);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    tiendaUI.ventanaTienda();
                });


                thread.start();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ButtonColors.setHoverBackgroundColor(tiendaButton);
            }
            public void mouseExited(MouseEvent e) {
                ButtonColors.setExitedBackgroundColor(tiendaButton);
            }
        });

        monedasInfo();

        cheatMoney.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Login user = loginRepository.findByNombre(User.username);
                if(user!=null){
                    user.setPokemonedas(user.getPokemonedas()+10);
                    loginRepository.save(user);
                    informacionPlayer.setText("<html><br><br>POKEMONEDAS: "+user.getPokemonedas()+"</html>");
                }


            }

            public void mouseEntered(MouseEvent e) {
                ButtonColors.setHoverBackgroundColor(cheatMoney);
            }
            public void mouseExited(MouseEvent e) {
                ButtonColors.setExitedBackgroundColor(cheatMoney);
            }
        });
        luchar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Hilos
                Thread thread = new Thread(() ->
                {
                    //System.out.println("hilo ejecutado por"+Thread.currentThread().getName());
                    super.mouseClicked(e);
                    LuchaUI luchaUI = null;
                    try {
                        seleccionLucha();
                        luchaUI = new LuchaUI(appService);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    luchaUI.ventanaLucha();
                });

                thread.start();
            }
        });
    }

    public void main(JFrame frame) {
        frame.setContentPane(menuUI);
        frame.setVisible(true);
    }

    //INSERTAR IMÁGENES EN BOTONES
    private void imagesInPokemonButtons(String name,EquipoController equipoController)
    {
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

    private void infoPokemon(int id){
        Login login = loginRepository.findByNombre(User.username);
        if(login!=null){

            Equipo equipo = equipoController.getEquipo(login.getId());
            Pokemon p = PokemonService.getPokemon(id);
            if(p!=null){
            UIService.asignarTextoAlabel(String.format("<html>Nombre (id): %s (%s)<br>Tipos: %s<br>Exp.Base: %s</html>",p.name,p.id,p.getTipos(p),p.baseExperience),informPoke);
            }else{
                UIService.asignarTextoAlabel("No hay pokemon en el equipo",informPoke);
            }

        }
    }

    private void monedasInfo(){
        Login user = loginRepository.findByNombre(User.username);
        if(user!=null){
            informacionPlayer.setText("<html><br><br>POKEMONEDAS: "+user.getPokemonedas()+"</html>");
            informacionPlayer.setFocusable(false);
            informacionPlayer.setVisible(true);
        }
    }

    private void seleccionLucha()
    {
        ImageIcon imageIcon1,imageIcon2,imageIcon3,imageIcon4,imageIcon5,imageIcon6;
        Login login = loginRepository.findLoginById(User.id);

        try {
            imageIcon1 = new ImageIcon(new URL(PokemonService.urlSpritePokemonByID(equipoRepository.getEquipoById(User.id).getP1())));
        }catch(java.net.MalformedURLException e){
            imageIcon1 = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        }
        try {
            imageIcon2 = new ImageIcon(new URL(PokemonService.urlSpritePokemonByID(equipoRepository.getEquipoById(User.id).getP2())));
        }catch(java.net.MalformedURLException e){
            imageIcon2 = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        }
        try {
            imageIcon3 = new ImageIcon(new URL(PokemonService.urlSpritePokemonByID(equipoRepository.getEquipoById(User.id).getP3())));
        }catch(java.net.MalformedURLException e){
            imageIcon3 = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        }
        try {
            imageIcon4 = new ImageIcon(new URL(PokemonService.urlSpritePokemonByID(equipoRepository.getEquipoById(User.id).getP4())));
        }catch(java.net.MalformedURLException e){
            imageIcon4 = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        }
        try {
            imageIcon5 = new ImageIcon(new URL(PokemonService.urlSpritePokemonByID(equipoRepository.getEquipoById(User.id).getP5())));
        }catch(java.net.MalformedURLException e){
            imageIcon5 = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        }
        try {
            imageIcon6 = new ImageIcon(new URL(PokemonService.urlSpritePokemonByID(equipoRepository.getEquipoById(User.id).getP6())));
        }catch(java.net.MalformedURLException e){
            imageIcon6 = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        }

        Icon iconoPersonalizado = new ImageIcon("src/main/resources/img/defaultPokeball.png");
        int opcionElegida = JOptionPane.showOptionDialog(
                null,"En qué espacio deseas añadir este pokémon?","Comprando Pokémon",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE,
                iconoPersonalizado,
                //new Object[]{"Pokémon 1","Pokémon 2","Pokémon 3","Pokémon 4","Pokémon 5","Pokémon 6", "Cancelar"},

                new Object[]{
                        imageIcon1,
                        imageIcon2,
                        imageIcon3,
                        imageIcon4,
                        imageIcon5,
                        imageIcon6, "Cancelar"
                },
                "Cancelar"
        );

        if (opcionElegida == JOptionPane.YES_OPTION) {
            // Se seleccionó "Reintentar"
            // Aquí colocas el código para reintentar la operación

        } else if (opcionElegida == JOptionPane.NO_OPTION || opcionElegida == JOptionPane.CLOSED_OPTION) {

            // Se seleccionó "Cancelar" o se cerró el cuadro de diálogo
            // Aquí colocas el código para manejar la cancelación
        }

        // Manejar la opción elegida
        Equipo equipo = equipoRepository.findEquipoById(User.id);
        if(equipo!= null) {
            switch (opcionElegida) {
                case 0:
                    PokemonList.pokemonElegido = equipo.getP1();
                    break;
                case 1:
                    PokemonList.pokemonElegido = equipo.getP2();
                    break;
                case 2:
                    PokemonList.pokemonElegido = equipo.getP3();
                    break;
                case 3:
                    PokemonList.pokemonElegido = equipo.getP4();
                    break;
                case 4:
                    PokemonList.pokemonElegido = equipo.getP5();
                    break;
                case 5:
                    PokemonList.pokemonElegido = equipo.getP6();
                    break;
                case 6:
                    break;
                default:
                    break;
            }
            //System.out.println("ES MONDONGO "+PokemonList.pokemonElegido);
        }
    }
}
