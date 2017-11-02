package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.config.patch.json.Patch;
import pl.adamklimko.zeroseg.config.patch.json.PatchRequestBody;
import pl.adamklimko.zeroseg.model.Settings;
import pl.adamklimko.zeroseg.service.SettingsService;
import pl.adamklimko.zeroseg.service.impl.SettingsServiceImpl;

@RestController
@RequestMapping("/settings")
public class SettingsController {
    private final SettingsServiceImpl ss;

    @Autowired
    public SettingsController(SettingsServiceImpl ss) {
        this.ss = ss;
    }

    @GetMapping()
    public Settings getSettings() {
        return ss.getSettings();
    }

    @PutMapping()
    public Settings updateSettings(@RequestBody Settings settings) {
        settings.setId(1);
        ss.save(settings);
        return settings;
    }

    @PatchMapping()
    @Patch(id = Integer.class, service = SettingsService.class)
    public Settings patchWeather(@PatchRequestBody Settings settings) {
        settings.setId(1);
        ss.save(settings);
        return settings;
    }
}
