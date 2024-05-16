package poke.app.controller;

import org.springframework.stereotype.Component;
import poke.app.entity.Usuario;
import poke.app.repository.LoginRepository;
import poke.app.repository.UsuarioRepository;

@Component
public class UsuarioController {
    private UsuarioRepository usuarioRepository;
    private LoginRepository loginRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, LoginRepository loginRepository) {
        this.usuarioRepository = usuarioRepository;
        this.loginRepository = loginRepository;
    }

    public Usuario getUsuario(String login, String pass) {
        if(this.usuarioRepository.findByNombre(login) != null){
            if(this.usuarioRepository.findbyPass(pass)){
                Usuario user = this.usuarioRepository.findByNombre(login);
                System.out.println(user.toString());
            }else{
                System.out.println("Contraseña incorrecta");
            }
        }else{
            System.out.println("Usuario no encontrado");
        }
        return null;
    }

    public boolean login(String username, String password) {
        Usuario user = usuarioRepository.findByNombre(username);
        if (user != null && user.getPass().equals(password)) {
            // Login successful
            return true;
        } else {
            // Login failed
            return false;
        }
    }
}
