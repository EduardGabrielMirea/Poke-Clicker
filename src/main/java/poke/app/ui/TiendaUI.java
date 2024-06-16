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
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps1);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps2);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps3);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps4);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps5);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps6);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps7);
        UIService.mostrarImagenEnJlabelByIdStatico(UIService.pokemonRandomizer(PokemonList.primeraEtapaIDs), ps8);

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
                }
                comprar.setEnabled(false);
            }
        });

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
                try {
                    Equipo equipo = equipoRepository.findEquipoById(user);
                    switch(slot){
                        case 1:
                            Login login = loginRepository.findLoginById(user);
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
        });
    }

    private void botonesCompra() {
        if (suficienteDinero(false, true)) {
            comprar.setEnabled(true);
        }
        evolucionar.setEnabled(false);
    }


    /*private void descripcionEquipo(JTextArea jTextArea) {
        //PokemonSpecies p = PokemonService.llamadasAPISpeciesID(id);
        //assert p != null;
        Login login = loginRepository.findLoginById(User.id);
        if (login == null) {
            User.id = login.getId();
            descripcionEquipo(equipoPokemonLista);
        }else{
            UIService.asignarTextoAJTextArea(String.format("Pokemon 1: %s" +
                            "Pokemon 2: %s" +
                            "Pokemon 3: %s" +
                            "Pokemon 4: %s" +
                            "Pokemon 5: %s" +
                            "Pokemon 6: %s"
                    , equipoController.getEquipo(User.id).getP1(),
                    equipoController.getEquipo(User.id).getP2(),
                    equipoController.getEquipo(User.id).getP3(),
                    equipoController.getEquipo(User.id).getP4(),
                    equipoController.getEquipo(User.id).getP5(),
                    equipoController.getEquipo(User.id).getP6()), jTextArea);
        }
    }*/
}

        /*descripcionEquipo(1,equipoController.getEquipo(User.id).getP1(),equipoPokemonLista);
        descripcionEquipo(2,equipoController.getEquipo(User.id).getP2(),equipoPokemonLista);
        descripcionEquipo(3,equipoController.getEquipo(User.id).getP3(),equipoPokemonLista);
        descripcionEquipo(4,equipoController.getEquipo(User.id).getP4(),equipoPokemonLista);
        descripcionEquipo(5,equipoController.getEquipo(User.id).getP5(),equipoPokemonLista);
        descripcionEquipo(6,equipoController.getEquipo(User.id).getP6(),equipoPokemonLista);
    }
}

         */
