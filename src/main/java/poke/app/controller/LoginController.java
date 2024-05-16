package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.entity.Login;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

@Component
public class LoginController {
    private final LoginRepository loginRepository;
    @Autowired
    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    public static void login(String username, String password) {
        Login login = new Login(username, password);
    }
}
