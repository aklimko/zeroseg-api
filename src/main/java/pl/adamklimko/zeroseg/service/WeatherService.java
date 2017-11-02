package pl.adamklimko.zeroseg.service;

import pl.adamklimko.zeroseg.model.Weather;

public interface WeatherService {

    Weather find();
    Weather getWeather();
    void save(Weather weather);
}
