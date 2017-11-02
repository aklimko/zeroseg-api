package pl.adamklimko.zeroseg.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.user.AppUser;
import pl.adamklimko.zeroseg.repository.AppUserRepository;
import pl.adamklimko.zeroseg.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser find() {
        return appUserRepository.findByUsername(getUsernameFromContext());
    }

    private String getUsernameFromContext() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void save(AppUser user) {
        appUserRepository.save(user);
    }
}
