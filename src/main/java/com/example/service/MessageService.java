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
    public Message createMessage(Message message) {
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
    public Message updateMessage(int id, Message newMessage) {
        Optional<Message> oldMessage = messageRepository.findById(id);
        if (oldMessage.isPresent()) {
            if (oldMessage != null && newMessage.getMessageText().length() != 0 && newMessage.getMessageText().length() <= 255) {
                Message message = oldMessage.get();
                message.setMessageId(newMessage.getMessageId());
                messageRepository.save(message);
                return newMessage;
            }
        }
        return null;
    }

    // get all messages given account id
}
