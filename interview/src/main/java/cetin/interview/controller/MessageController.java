package cetin.interview.controller;

import cetin.interview.model.Message;
import cetin.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value="/api") // TODO Should be "/api/messages"
public class MessageController {

    @Autowired
    MessageService messageService;

    // TODO This is okay for a small application, but it's possible to create a global CORS configuration
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/all",method = RequestMethod.GET) // TODO Should not have specified value (GET /api/messages should be enough to get all)
    public Collection<Message> getAll() {
        return messageService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/count",method = RequestMethod.GET) // TODO Spring has annotations such as @GetMapping, @PostMapping
    public long getCount() {
        return messageService.getCount();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/last",method = RequestMethod.GET)
    public Collection<Message> getLast() {
       return messageService.getLast();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/set",method = RequestMethod.POST) // TODO Should just be POST /api/messages
    public void setMessage(String msg) { // TODO Message should be the request body
       messageService.set(msg);
    }
}
