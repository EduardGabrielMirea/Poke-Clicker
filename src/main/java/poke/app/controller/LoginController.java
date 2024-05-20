package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.entity.Login;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

@Component
public class LoginController {
    private static LoginRepository loginRepository;
    private final AppService appService;

    @Autowired
    public LoginController(LoginRepository loginRepository, AppService appService) {
        LoginController.loginRepository = loginRepository;
        this.appService = appService;
    }
/*
    public  boolean login(String username, String password) {
        Login login = loginRepository.findByNombre(username);
        if (login != null && login.getPass().equals(password)) {
            // Login successful
            System.out.println("true");
            return true;
        } else {
            // Login failed
            System.out.println("failed");
            return false;
        }
    }

 */

    public static boolean getInfo(String username, String password)
    {
        Login login = loginRepository.findByNombre(username);
        if (login != null && login.getPass().equals(password)) {
            // Login successful
            System.out.println("true");
            return true;
        } else {
            // Login failed
            System.out.println("failed");
            return false;
        }

    }
}
