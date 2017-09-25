package pl.adamklimko.zeroseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.MessageRead;
import pl.adamklimko.zeroseg.repository.MessageReadRepository;
import pl.adamklimko.zeroseg.repository.MessageRepository;
import pl.adamklimko.zeroseg.model.Message;

@Service
public class MessageService {
    private Message latest;
    private MessageRead latestRead;
    private final MessageRepository messageRepository;
    private final MessageReadRepository messageReadRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, MessageReadRepository messageReadRepository) {
        this.messageRepository = messageRepository;
        this.messageReadRepository = messageReadRepository;
        this.latest = messageRepository.findLastMessage();
        this.latestRead = messageReadRepository.getLastMessageRead();
    }

    public Message getLatest() {
        return latest;
    }

    public void setLatest(Message latest) {
        this.latest = latest;
    }

    public MessageRead getLatestRead() {
        return latestRead;
    }

    public void setLatestRead(MessageRead latestRead) {
        this.latestRead = latestRead;
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public MessageReadRepository getMessageReadRepository() {
        return messageReadRepository;
    }
}
