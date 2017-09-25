package pl.adamklimko.zeroseg.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.adamklimko.zeroseg.model.Message;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Query(value = "SELECT * FROM message ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Message findLastMessage();

    @Query(value = "SELECT * FROM message WHERE id > ?1",  nativeQuery = true)
    List<Message> findMessagesNewerThanId(Integer id);
}
