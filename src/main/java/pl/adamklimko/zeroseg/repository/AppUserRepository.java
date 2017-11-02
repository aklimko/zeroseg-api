package pl.adamklimko.zeroseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.user.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}
