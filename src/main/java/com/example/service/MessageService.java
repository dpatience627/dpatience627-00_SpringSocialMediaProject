package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // create new message
    public Message createMessage(Message message) {
        System.out.println("SERVICE " + message);
        if (message.getMessageText() != null && message.getMessageText().length() != 0
        && message.getMessageText().length() <= 255 && accountRepository.findById(message.getPostedBy()).isPresent()) {
            return messageRepository.save(message);
        }
        return null;
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
    public Message deleteMessage(int id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message deletedMessage = optionalMessage.get();
            messageRepository.deleteById(id);
            return deletedMessage;
        } else {
            return null;
        }   
    }

    // update message given message id
    public Message updateMessage(int id, Message newMessage) {
        Optional<Message> optionalOldMessage = messageRepository.findById(id);
        if (optionalOldMessage.isPresent()) {
            if (optionalOldMessage != null && newMessage.getMessageText().length() != 0 && newMessage.getMessageText().length() <= 255) {
                Message oldMessage = optionalOldMessage.get();
                oldMessage.setMessageText(newMessage.getMessageText());
                
                return messageRepository.save(oldMessage);
            }
        }
        return null;
    }

    // get all messages given account id
    public List<Message> getAllMessagesFromAccount(int id) {
        return null;
    }
}
