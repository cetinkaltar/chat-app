package cetin.interview.controller;

import cetin.interview.model.Message;
import cetin.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value="/api")
public class MessageController {

    @Autowired
    MessageService messageService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Collection<Message> getAll() {
        return messageService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public long getCount() {
        return messageService.getCount();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/last",method = RequestMethod.GET)
    public Collection<Message> getLast() {
       return messageService.getLast();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public void setMessage(String msg) {
       messageService.set(msg);
    }
}
