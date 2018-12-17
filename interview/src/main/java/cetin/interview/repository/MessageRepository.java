package cetin.interview.repository;

import cetin.interview.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {
    // TODO CrudRepository already has a count method, why not use that?
    @Query("SELECT COUNT(msg.id) FROM Message msg ")
    long count();

}
