package poke.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.entity.Login;
import poke.app.repository.LoginRepository;




@Component
public class LoginController{
    public final LoginRepository loginRepository;


    @Autowired
    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean login(String username, String password) {
        Login login = loginRepository.findByNombre(username);
        if (login != null && login.getPass().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean registro(String username, String password) {
        Login login = loginRepository.findByNombre(username);
        if (login == null) {
            return true;
        }else{
            return false;
        }
    }

    public boolean recuperarContraseña(String username,String password) {
        Login login = loginRepository.findByNombre(username);
        if (login != null){
            login.setPass(password);
            loginRepository.save(login);
            return true;
        }else{
            return false;
        }
    }

    public boolean isConfigured(String username){
        Login login = loginRepository.findByNombre(username);
        int dato = login.getNuevo_user();
        if(dato == 0){
            return false;
        }else{
            return true;
        }
    }

    public void setPersona(String username,int persona){
        Login login = loginRepository.findByNombre(username);
        if(login != null){
            login.setNuevo_user(persona);
            loginRepository.save(login);
        }
    }

    public int getPersonaGenero(String username)
    {
        Login login = loginRepository.findByNombre(username);


        if (login != null) {
            if (login.getNuevo_user()==1)
            {
               return 1;
            }
            if (login.getNuevo_user()==2)
            {
                return 2;
            }
        }
        return 0;
    }

    public String getPersonaNombre(String username)
    {
        Login login = loginRepository.findByNombre(username);


        if (login != null) {
            return login.getNombre();

        }
        return null;
    }

}
