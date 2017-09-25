package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Message> getLastMessage() {
        return new ResponseEntity<>(ms.getLatest(), HttpStatus.OK);
    }

    @GetMapping("/from/{id}")
    public ResponseEntity<List<Message>> getLatestMessagesFromId(@PathVariable Integer id) {
        List<Message> messages = ms.getMessageRepository().findMessagesNewerThanId(id);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        ms.getMessageRepository().save(message);
        ms.setLatest(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<MessageRead> getLatestReadMessageId() {
        return new ResponseEntity<>(ms.getLatestRead(), HttpStatus.OK);
    }

    @PutMapping("/read")
    public ResponseEntity<MessageRead> updateLatestReadMessageId(@RequestBody MessageRead latestRead) {
        ms.getMessageReadRepository().save(latestRead);
        ms.setLatestRead(latestRead);
        return new ResponseEntity<>(latestRead, HttpStatus.OK);
    }
}
