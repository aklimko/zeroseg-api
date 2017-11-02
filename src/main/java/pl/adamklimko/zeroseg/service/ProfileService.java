package pl.adamklimko.zeroseg.service;

import pl.adamklimko.zeroseg.model.user.Profile;

public interface ProfileService {
    Profile find();
    void save(Profile profile);
}
