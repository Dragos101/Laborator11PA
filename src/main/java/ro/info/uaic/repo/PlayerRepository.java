package ro.info.uaic.repo;

import org.springframework.data.repository.CrudRepository;
import ro.info.uaic.entity.PlayerEnt;

public interface PlayerRepository extends CrudRepository<PlayerEnt, String> {

}
