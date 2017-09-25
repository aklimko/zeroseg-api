package pl.adamklimko.zeroseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.Weather;
import pl.adamklimko.zeroseg.repository.WeatherRepository;

@Service
public class WeatherService {
    private Weather weather;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
        weather = weatherRepository.findWeather();
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public WeatherRepository getWeatherRepository() {
        return weatherRepository;
    }
}
