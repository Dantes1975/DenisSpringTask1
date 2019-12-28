package repository;

import bean.Event;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Repository
public class EventRepositoryImpl extends AbstractRepository<Event> implements EventRepository {
    private static Map<Long, Event> EVENTS = new HashMap<Long, Event>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private void initDefaultEvents(List<Event> events) {
        for (Event event : events) {
            long id = ID.getAndIncrement();
            event.setId(id);
            EVENTS.put(id, event);
        }
    }
}
