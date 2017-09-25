package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.model.Settings;
import pl.adamklimko.zeroseg.service.SettingsService;

@RestController
@RequestMapping("/settings")
public class SettingsController {
    private final SettingsService ss;

    @Autowired
    public SettingsController(SettingsService ss) {
        this.ss = ss;
    }

    @GetMapping()
    public @ResponseBody ResponseEntity<Settings> getSettings() {
        return new ResponseEntity<>(ss.getSettings(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Settings> updateSettings(@RequestBody Settings settings) {
        ss.getSettingsRepository().save(settings);
        ss.setSettings(settings);
        return new ResponseEntity<>(settings, HttpStatus.OK);
    }
}
