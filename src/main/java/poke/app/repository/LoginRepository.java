package poke.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import poke.app.entity.Login;
@Component
public interface LoginRepository extends CrudRepository<Login, Long> {
    /**
     * Encuentra un Login por nombre de usuario.
     *
     * @param nombre Nombre de usuario.
     * @return La entidad Login correspondiente.
     */
    Login findByNombre(String nombre);

    /**
     * Verifica si existe un Login por nombre de usuario.
     *
     * @param nombre Nombre de usuario.
     * @return True si existe, de lo contrario false.
     */
    boolean existsByNombre(String nombre);

    Login findLoginById(long id);

    Long getIdByNombre(String nombre);
}
