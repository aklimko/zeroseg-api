package pl.adamklimko.zeroseg.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.Weather;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    @Query(value = "SELECT * FROM weather LIMIT 1", nativeQuery = true)
    Weather findWeather();
}
