package pl.adamklimko.zeroseg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.Weather;
import pl.adamklimko.zeroseg.repository.WeatherRepository;
import pl.adamklimko.zeroseg.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
    private Weather weather;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
        this.weather = weatherRepository.findOne(1);
    }

    @Override
    public Weather find() {
        return weather;
    }

    @Override
    public Weather getWeather() {
        return weather;
    }

    @Override
    public void save(Weather weather) {
        weatherRepository.save(weather);
        this.weather = weather;
    }
}
