package poke.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import poke.app.entity.Login;
import poke.app.entity.Usuario;

@Component
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    /**
     * Encuentra un Login por nombre de usuario.
     *
     * @param nombre Nombre de usuario.
     * @return La entidad Login correspondiente.
     */
    Usuario findByNombre(String nombre);

    /**
     * Verifica si existe un Login por nombre de usuario.
     *
     * @param nombre Nombre de usuario.
     * @return True si existe, de lo contrario false.
     */
    boolean existsByNombre(String nombre);
    boolean findbyPass(String pass);

}
