package pl.adamklimko.zeroseg.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.config.patch.json.Patch;
import pl.adamklimko.zeroseg.config.patch.json.PatchRequestBody;
import pl.adamklimko.zeroseg.model.user.AppUser;
import pl.adamklimko.zeroseg.model.user.Profile;
import pl.adamklimko.zeroseg.service.AppUserService;
import pl.adamklimko.zeroseg.service.ProfileService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final AppUserService appUserService;
    private final ProfileService profileService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(AppUserService appUserService, ProfileService profileService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserService = appUserService;
        this.profileService = profileService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        appUserService.save(user);
    }

    @GetMapping("/profile")
    public Profile getProfile() {
        return appUserService.findByUsername(getUsernameFromContext()).getProfile();
    }

    @PatchMapping("/profile")
    @Patch(id = Integer.class, service = ProfileService.class)
    public Profile patchProfile(@PatchRequestBody Profile profile) {
        final AppUser user = appUserService.findByUsername(getUsernameFromContext());
        if (user.getProfile() == null) {
            user.setProfile(profile);
        }
        profileService.save(profile);
        return profile;
    }

    private String getUsernameFromContext() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
