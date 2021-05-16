package ro.info.uaic.repo;

import org.springframework.data.repository.CrudRepository;
import ro.info.uaic.entity.PersonEnt;

public interface PersonRepository extends CrudRepository<PersonEnt, String> {

}
