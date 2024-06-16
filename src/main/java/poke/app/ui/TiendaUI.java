package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.entity.*;
import poke.app.localData.PokemonList;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.EvolucionesRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.ButtonColors;
import poke.app.service.PokemonService;
import poke.app.service.UIService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;


@Component
public class TiendaUI {
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private MenuController menuController;
    private EvolucionesRepository evolucionesRepository;

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
    private JTextArea equipoPokemonLista;
    private int slot = 0;
    private int pokemonEquipo = 0;
    private int pokemonShop = 0;

    private int pshop1 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop2 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop3 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop4 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop5 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop6 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop7 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);
    private int pshop8 = UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs);

    private int compraElegida = 0;

    public TiendaUI(AppService appService) throws IOException {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.menuController = appService.getMenuController();
        this.evolucionesRepository = appService.getEvolucionesRepository();

        ButtonColors.setColors(comprar);
        ButtonColors.setColors(evolucionar);
        ButtonColors.setColors(salir);


        //Mostrar Pokemon del equipo en tienda
        if (User.id != null) {
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP1(), p1);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP2(), p2);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP3(), p3);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP4(), p4);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP5(), p5);
            UIService.mostrarImagenEnJlabelByIdStatico(equipoController.getEquipo(User.id).getP6(), p6);
        }

        //Tienda Pokemon con scrollbar

        UIService.mostrarImagenEnJlabelByIdStatico(pshop1, ps1);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop2, ps2);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop3, ps3);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop4, ps4);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop5, ps5);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop6, ps6);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop7, ps7);
        UIService.mostrarImagenEnJlabelByIdStatico(pshop8, ps8);

        //Listeners pestaña Equipo
        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slot =1;
                pokemonEquipo = equipoController.getEquipo(User.id).getP1();
                if (suficienteDinero(true, false)) {
                    evolucionar.setEnabled(true);
                }
                else
                {
                    evolucionar.setEnabled(false);
                }
                comprar.setEnabled(false);
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slot = 2;
                pokemonEquipo = equipoController.getEquipo(User.id).getP2();
                if (suficienteDinero(true, false)) {
                    evolucionar.setEnabled(true);
                }

                else
                {
                    evolucionar.setEnabled(false);
                }
                comprar.setEnabled(false);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slot = 3;
                pokemonEquipo = equipoController.getEquipo(User.id).getP3();
                if (suficienteDinero(true, false)) {
                    evolucionar.setEnabled(true);
                }else{
                    evolucionar.setEnabled(false);
                }
                comprar.setEnabled(false);
            }
        });
        p4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slot = 4;
                pokemonEquipo = equipoController.getEquipo(User.id).getP4();
                if (suficienteDinero(true, false)) {
                    evolucionar.setEnabled(true);
                }else{
                    evolucionar.setEnabled(false);
                }
                comprar.setEnabled(false);
            }
        });
        p5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slot = 5;
                pokemonEquipo = equipoController.getEquipo(User.id).getP5();
                if (suficienteDinero(true, false)) {
                    evolucionar.setEnabled(true);
                }else{
                    evolucionar.setEnabled(false);
                }
                comprar.setEnabled(false);
            }
        });
        p6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slot = 6;
                pokemonEquipo = equipoController.getEquipo(User.id).getP6();
                if (suficienteDinero(true, false)) {
                    evolucionar.setEnabled(true);
                }else{
                    evolucionar.setEnabled(false);
                }
                comprar.setEnabled(false);
            }
        });

        //Listeners Pokemon Shop
        ps1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop1;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop2;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop3;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop4;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop5;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop6;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop7;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });
        ps8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (suficienteDinero(false, true)) {
                    comprar.setEnabled(true);
                    compraElegida = pshop8;
                }else{
                    comprar.setEnabled(false);
                }
                evolucionar.setEnabled(false);
            }
        });

        //INFORMACIÓN EQUIPO POKEMON
        //descripcionEquipo(equipoPokemonLista);
        if(User.id != null) {
            UIService.asignarTextoAJTextArea(String.format("Pokemon 1: %s\n" +
                                    "Pokemon 2: %s\n" +
                                    "Pokemon 3: %s\n" +
                                    "Pokemon 4: %s\n" +
                                    "Pokemon 5: %s\n" +
                                    "Pokemon 6: %s"
                            , PokemonService.getName(equipoController.getEquipo(User.id).getP1()),
                            PokemonService.getName(equipoController.getEquipo(User.id).getP2()),
                            PokemonService.getName(equipoController.getEquipo(User.id).getP3()),
                            PokemonService.getName(equipoController.getEquipo(User.id).getP4()),
                            PokemonService.getName(equipoController.getEquipo(User.id).getP5()),
                            PokemonService.getName(equipoController.getEquipo(User.id).getP6())),
                    equipoPokemonLista);
        }
        //Botones de la tienda
        comprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                botonesCompra();
            }
        });

        evolucionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                realizaEvolucion(User.id,slot,pokemonEquipo);
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
        } else {
            return null;
        }
    }


    private boolean suficienteDinero(boolean evolucion, boolean compra) {
        Login login = loginRepository.findLoginById(User.id);
        if (login != null) {
            if (compra) {
                if (login.getPokemonedas() >= 10) {
                    return true;
                }
            } else if (evolucion) {
                if (login.getPokemonedas() >= 50) {
                    return true;
                }
            }
        }
        return false;
    }

    private void realizaEvolucion(Long user,int slot,int id) {
        Optional<Evoluciones> ev = evolucionesRepository.findById(id);
        ev.ifPresent(evoluciones -> {
            //NOMBRE DE LA EVOLUCIÓN
            Pokemon p = PokemonService.llamadasAPIporID(evoluciones.getE2());
            if(p != null) {

                //System.out.println(p.name);
                //System.out.println(p.id);
                Login login = loginRepository.findLoginById(user);

                if(suficienteDinero(true,false)){
                    login.setPokemonedas(login.getPokemonedas()-50);
                    loginRepository.save(login);
                try {
                    Equipo equipo = equipoRepository.findEquipoById(user);
                    switch(slot){
                        case 1:
                            login = loginRepository.findLoginById(user);
                            if(login != null) {
                                equipo.setP1(p.id);
                                equipoRepository.save(equipo);
                                UIService.mostrarImagenEnJlabelByIdStatico(equipo.getP1(), p1);
                            }
                            break;
                        case 2:
                            equipo.setP2(p.id);
                            equipoRepository.save(equipo);
                            UIService.mostrarImagenEnJlabelByIdStatico(equipo.getP2(), p2);
                            break;
                        case 3:
                            equipo.setP3(p.id);
                            equipoRepository.save(equipo);
                            UIService.mostrarImagenEnJlabelByIdStatico(equipo.getP1(), p3);
                            break;
                        case 4:
                            equipo.setP4(p.id);
                            equipoRepository.save(equipo);
                            UIService.mostrarImagenEnJlabelByIdStatico(equipo.getP1(), p4);
                            break;
                        case 5:
                            equipo.setP5(p.id);
                            equipoRepository.save(equipo);
                            UIService.mostrarImagenEnJlabelByIdStatico(equipo.getP1(), p5);
                            break;
                        case 6:
                            equipo.setP6(p.id);
                            equipoRepository.save(equipo);
                            UIService.mostrarImagenEnJlabelByIdStatico(equipo.getP1(), p6);
                            break;
                    }

                } catch (IOException ew) {
                    throw new RuntimeException(ew);
                }
                }
            }
        });
    }

    private void botonesCompra(){
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

        if(suficienteDinero(false,true)) {
            login.setPokemonedas(login.getPokemonedas() - 10);
            loginRepository.save(login);

            // Manejar la opción elegida
            Equipo equipo = equipoRepository.findEquipoById(User.id);
            if(equipo!= null) {
                switch (opcionElegida) {
                    case 0:
                        equipo.setP1(compraElegida);
                        break;
                    case 1:
                        equipo.setP2(compraElegida);
                        break;
                    case 2:
                        equipo.setP3(compraElegida);
                        break;
                    case 3:
                        equipo.setP4(compraElegida);
                        break;
                    case 4:
                        equipo.setP5(compraElegida);
                        break;
                    case 5:
                        equipo.setP6(compraElegida);
                        break;
                    case 6:
                        break;
                    default:
                        break;
                }
                equipoRepository.save(equipo);
            }
        }
    }

}
