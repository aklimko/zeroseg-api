package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.model.Weather;
import pl.adamklimko.zeroseg.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService ws;

    @Autowired
    public WeatherController(WeatherService ws) {
        this.ws = ws;
    }

    @GetMapping()
    public @ResponseBody ResponseEntity<Weather> getWeather() {
        return new ResponseEntity<>(ws.getWeather(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Weather> updateWeather(@RequestBody Weather weather) {
        Weather w = ws.getWeather();
        w.setTemperature(weather.getTemperature());
        w.setHumidity(weather.getHumidity());
        w.setPressure(weather.getPressure());
        ws.getWeatherRepository().save(w);
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }
}
