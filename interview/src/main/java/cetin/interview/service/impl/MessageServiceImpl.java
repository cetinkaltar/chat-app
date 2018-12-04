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
        Timestamp ts = new Timestamp(time);

        Message message = new Message();
        message.setMessage(msg);
        message.setDate(ts);

        messageRepository.save(message);
    }
}
