package poke.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import poke.app.entity.Equipo;

@Component
public interface EquipoRepository extends CrudRepository<Equipo,Long> {

}
