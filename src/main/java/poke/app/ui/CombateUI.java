package poke.app.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;
import poke.app.service.UIService;

import javax.swing.*;
@Component
public class CombateUI {

    private LoginController loginController;
    private LoginRepository loginRepository;
    private EquipoRepository equipoRepository;
    private EquipoController equipoController;
    private final ApplicationContext context;
    private final JFrame frame = Window.frame;

    private JPanel principal;
    private JPanel combate;
    private JPanel informacion;
    private JPanel pokemonFoto;
    private JPanel informacionPokemon;
    private JTextArea txtInfoPokemon;
    private JLabel lblFotoPokemon;

    public CombateUI(AppService appService, ApplicationContext context) {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.context = context;

        //LLAMA AL MÉTODO PARA INSERTAR IMÁGENES EN LAS CASILLAS DE LOS POKEMON
        imagesInPokemon(User.username,equipoController);



    }
    //INSERTAR IMÁGENES EN BOTONES | SE PODRÍA MOVER A MenuController
    private void imagesInPokemon(String name,EquipoController equipoController)
    {
        //Cambiar luego de refactorizar y unir las tablas bien
        Login login = loginRepository.findByNombre(name);
        if(login!=null){

            Equipo equipo = equipoController.getEquipo(login.getId());
            UIService.mostrarImagenEnLabelById(equipo.getP1(),lblFotoPokemon);
        }

    }


    public void initCombateUI() {
        frame.setContentPane(principal);
        frame.setVisible(true);
    }
}
