package pl.adamklimko.zeroseg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.user.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{
}
