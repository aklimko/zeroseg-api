package pl.adamklimko.zeroseg.service;

import pl.adamklimko.zeroseg.model.user.AppUser;

public interface AppUserService {
    AppUser find();

    AppUser findByUsername(String username);

    void save(AppUser user);
}
