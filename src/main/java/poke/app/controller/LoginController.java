package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.repository.LoginRepository;

@Component
public class LoginController {
    private final LoginRepository loginRepository;
    @Autowired

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

}
