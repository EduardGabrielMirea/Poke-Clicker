package poke.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import poke.app.entity.Login;
@Component
public interface LoginRepository extends CrudRepository<Login, Long> {

}
