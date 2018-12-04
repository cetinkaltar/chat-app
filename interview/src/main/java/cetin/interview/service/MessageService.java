package cetin.interview.service;

import cetin.interview.model.Message;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MessageService {

     Collection<Message> getAll();
     long getCount();
     Collection<Message> getLast();
     void set(String msg);
}
