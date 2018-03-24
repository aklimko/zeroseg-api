package pl.adamklimko.zeroseg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.MessageRead;
import pl.adamklimko.zeroseg.repository.MessageReadRepository;
import pl.adamklimko.zeroseg.repository.MessageRepository;
import pl.adamklimko.zeroseg.model.Message;
import pl.adamklimko.zeroseg.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private Message latest;
    private MessageRead lastRead;
    private final MessageRepository messageRepository;
    private final MessageReadRepository messageReadRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, MessageReadRepository messageReadRepository) {
        this.messageRepository = messageRepository;
        this.messageReadRepository = messageReadRepository;
        this.latest = messageRepository.findLastMessage();
        this.lastRead = messageReadRepository.findOne("last_read");
    }

    public Message getLatest() {
        return latest;
    }

    public MessageRead getLastRead() {
        return lastRead;
    }

    @Override
    public void saveMessage(Message message) {
        latest = message;
        messageRepository.save(message);
    }

    @Override
    public void saveMessageRead(MessageRead latestRead) {
        this.lastRead = latestRead;
        messageReadRepository.save(latestRead);
    }

    @Override
    public List<Message> findMessagesNewerThanId(int id) {
        return messageRepository.findMessagesNewerThanId(id);
    }
}
