package poke.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import poke.app.entity.Evoluciones;
import poke.app.entity.Login;

import java.util.Optional;

@Component
public interface EvolucionesRepository extends CrudRepository<Evoluciones, Integer> {
    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Evoluciones> findAllById(Iterable<Integer> integers);

    @Override
    Optional<Evoluciones> findById(Integer integer);

    @Override
    Iterable<Evoluciones> findAll();
}
