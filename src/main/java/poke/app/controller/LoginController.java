package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.PokeApp;
import poke.app.entity.Login;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

@Component
public class LoginController {
    private final LoginRepository loginRepository;
    private final AppService appService;

    @Autowired
    public LoginController(LoginRepository loginRepository, AppService appService) {
        this.loginRepository = loginRepository;
        this.appService = appService;
    }

    public boolean login(String username, String password) {
        Login login = loginRepository.findByNombre(username);
        if (login != null && login.getPass().equals(password)) {
            // Login successful
            System.out.println("BIEN");
            PokeApp.pantalla = 1;
            return true;
        } else {
            System.out.println("MAL");
            // Login failed
            return false;
        }
    }

    public boolean registro(String username, String password) {
        Login login = loginRepository.findByNombre(username);
        if (login == null) {
            loginRepository.save(new Login(username,password));
            System.out.println("Registrado");
        }else{
            System.out.println("Usuario ya existe");
        }
        return true;
    }

    public boolean recuperarContraseña(String username,String password) {
        Login login = loginRepository.findByNombre(username);
        if (login != null){
            login.setPass(password);
            loginRepository.save(login);
            System.out.println("Contraseña cambiada correctamente");
            return true;
        }else{
            System.out.println("Usuario no encontrado");
            return false;
        }
    }
}
