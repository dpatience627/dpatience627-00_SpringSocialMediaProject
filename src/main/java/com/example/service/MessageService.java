package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // create new message
    public Message persistGrocery(Message message){
        return messageRepository.save(message);
    }

    // get all messages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // get message given message id
    public Message getMessageByID(int id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            return optionalMessage.get();
        } else {
            return null;
        }
    }

    // delete message given message id
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }

    // update message given message id

    // get all messages given account id
}
