package pl.adamklimko.zeroseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.Settings;
import pl.adamklimko.zeroseg.repository.SettingsRepository;

import java.util.Map;
import java.util.TreeMap;

@Service
public class SettingsService {
    private Settings settings;
    private final SettingsRepository settingsRepository;

    @Autowired
    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
        this.settings = settingsRepository.findSettings();
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public SettingsRepository getSettingsRepository() {
        return settingsRepository;
    }
}
