package poke.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poke.app.config.AppConfig;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.controller.PokemonController;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;

import javax.swing.*;

@Service
public class AppService
{
    private final EquipoRepository equipoRepository;
    private final EquipoController equipoController;
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final MenuController menuController;
    private final PokemonController pokemonController;
    private final AppConfig appConfig;
    @Autowired
    public AppService(EquipoRepository equipoRepository, EquipoController equipoController, LoginController loginController, LoginRepository loginRepository, MenuController menuController, PokemonController pokemonController, AppConfig appConfig) {
        this.equipoRepository = equipoRepository;
        this.equipoController = equipoController;
        this.loginController = loginController;
        this.loginRepository = loginRepository;
        this.menuController = menuController;
        this.pokemonController = pokemonController;
        this.appConfig = appConfig;
    }


    public EquipoRepository getEquipoRepository() {
        return equipoRepository;
    }

    public EquipoController getEquipoController() {
        return equipoController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public LoginRepository getLoginRepository() {
        return loginRepository;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public PokemonController getPokemonController() {
        return pokemonController;
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

}
