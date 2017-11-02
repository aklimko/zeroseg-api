package pl.adamklimko.zeroseg.service;

import pl.adamklimko.zeroseg.model.Message;
import pl.adamklimko.zeroseg.model.MessageRead;

import java.util.List;

public interface MessageService {

    Message getLatest();

    MessageRead getLastRead();

    void saveMessage(Message message);

    void saveMessageRead(MessageRead latestRead);

    List<Message> findMessagesNewerThanId(int id);
}
