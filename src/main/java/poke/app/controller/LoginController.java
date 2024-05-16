package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
            return true;
        } else {
            // Login failed
            return false;
        }
    }
}
