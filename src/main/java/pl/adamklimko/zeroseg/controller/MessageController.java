package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.model.Message;
import pl.adamklimko.zeroseg.model.MessageRead;
import pl.adamklimko.zeroseg.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService ms;

    @Autowired
    public MessageController(MessageService ms) {
        this.ms = ms;
    }

    @GetMapping("/latest")
    public Message getLastMessage() {
        return ms.getLatest();
    }

    @GetMapping("/from/{id}")
    public List<Message> getLatestMessagesFromId(@PathVariable Integer id) {
        return ms.findMessagesNewerThanId(id);
    }

    @PostMapping()
    public Message addMessage(@RequestBody Message message) {
        ms.saveMessage(message);
        return message;
    }

    @GetMapping("/read")
    public MessageRead getLatestReadMessageId() {
        return ms.getLastRead();
    }

    @PutMapping("/read")
    public MessageRead updateLatestReadMessageId(@RequestBody MessageRead latestRead) {
        ms.saveMessageRead(latestRead);
        return latestRead;
    }
}
