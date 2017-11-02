package pl.adamklimko.zeroseg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.Settings;
import pl.adamklimko.zeroseg.repository.SettingsRepository;
import pl.adamklimko.zeroseg.service.SettingsService;

@Service
public class SettingsServiceImpl implements SettingsService {
    private Settings settings;
    private final SettingsRepository settingsRepository;

    @Autowired
    public SettingsServiceImpl(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
        this.settings = settingsRepository.findOne(1);
    }

    @Override
    public Settings find() {
        return settings;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public void save(Settings settings) {
        settingsRepository.save(settings);
        this.settings = settings;
    }

}
