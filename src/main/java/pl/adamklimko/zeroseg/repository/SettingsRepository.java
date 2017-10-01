package pl.adamklimko.zeroseg.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.Settings;

@Repository
public interface SettingsRepository extends CrudRepository<Settings, Integer> {
    @Query(value = "SELECT * FROM settings LIMIT 1", nativeQuery = true)
    Settings findSettings();
}
