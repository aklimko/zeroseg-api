package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.config.patch.json.Patch;
import pl.adamklimko.zeroseg.config.patch.json.PatchRequestBody;
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
    public Weather getWeather() {
        return ws.getWeather();
    }

    @PutMapping()
    public Weather updateWeather(@RequestBody Weather weather) {
        weather.setId(1);
        ws.save(weather);
        return weather;
    }

    @PatchMapping()
    @Patch(id = Integer.class, service = WeatherService.class)
    public Weather patchWeather(@PatchRequestBody Weather weather) {
        weather.setId(1);
        ws.save(weather);
        return weather;
    }
}
