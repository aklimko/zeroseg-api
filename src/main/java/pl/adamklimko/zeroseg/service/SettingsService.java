package pl.adamklimko.zeroseg.service;

import pl.adamklimko.zeroseg.model.Settings;

public interface SettingsService {

    Settings find();
    Settings getSettings();
    void save(Settings settings);
}
