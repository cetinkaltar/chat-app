package cetin.interview.service.impl;

import cetin.interview.model.Message;
import cetin.interview.repository.MessageRepository;
import cetin.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Collection<Message> getAll() {
        return (Collection<Message>) messageRepository.findAll();
    }

    public long getCount() {
        return messageRepository.count();
    }

    public Collection<Message> getLast() {
        // TODO Very odd way of getting the last message.
        // We don't need to fetch all messages from DB just to iterate over every one of them and take the last.
        // Spring Data has method syntax to order by date and take first.
        List<Message> messages = new ArrayList<Message>();
        Message msg=new Message();
        for (Message message : messageRepository.findAll()) {
            msg=message;
        }
        messages.add(msg);
        return messages;
    }

    public void set(String msg) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time); // TODO Would be just Instant.now() if we would use Java 8 API

        Message message = new Message();
        message.setMessage(msg);
        message.setDate(ts);

        messageRepository.save(message);
    }
}
