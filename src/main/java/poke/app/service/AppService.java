package poke.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poke.app.entity.Login;
import poke.app.repository.LoginRepository;

@Service
public class AppService {
    private final LoginRepository loginRepository;
    @Autowired

    public AppService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
 public LoginRepository getLoginRepository() {return  loginRepository;}
}
