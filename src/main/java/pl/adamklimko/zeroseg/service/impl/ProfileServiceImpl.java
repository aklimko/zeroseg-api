package pl.adamklimko.zeroseg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.user.Profile;
import pl.adamklimko.zeroseg.repository.AppUserRepository;
import pl.adamklimko.zeroseg.repository.ProfileRepository;
import pl.adamklimko.zeroseg.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, AppUserRepository appUserRepository) {
        this.profileRepository = profileRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Profile find() {
        final Profile profile = appUserRepository.findByUsername(getUsernameFromContext()).getProfile();
        if (profile == null) {
            return new Profile();
        }
        return profile;
    }

    private String getUsernameFromContext() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }
}
