package pl.adamklimko.zeroseg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.MessageRead;

@Repository
public interface MessageReadRepository extends CrudRepository<MessageRead, String> {
}
