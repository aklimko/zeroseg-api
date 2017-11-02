package pl.adamklimko.zeroseg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.Settings;

@Repository
public interface SettingsRepository extends CrudRepository<Settings, Integer> {
}
