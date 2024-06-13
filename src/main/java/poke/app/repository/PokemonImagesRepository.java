package poke.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import poke.app.entity.PokemonImages;

@Component
public interface PokemonImagesRepository extends CrudRepository<PokemonImages, Long> {

}
