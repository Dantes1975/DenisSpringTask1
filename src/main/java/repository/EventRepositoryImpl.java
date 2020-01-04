package repository;

import bean.Event;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.dao.CrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import static util.ErrorConstant.*;

@Data
@Repository
public class EventRepositoryImpl implements CrudRepository<Event> {
    private static Map<Long, Event> EVENTS = new HashMap<Long, Event>();
    private static AtomicLong ID = new AtomicLong(1);


    @Override
    public Event save(Event event) {
        long id = ID.getAndIncrement();
        event.setId(id);
        EVENTS.put(id, event);
        return getById(id);
    }

    @Override
    public void remove(long id) {
        EVENTS.remove(id);
    }

    @Override
    public Event getById(long id) {
        return EVENTS.get(id);
    }

    @Override
    public List<Event> getAll() {
        List<Event> list = new ArrayList<>(EVENTS.values());
        return list;
    }

    @Override
    public Map<Long, Event> getStorage() {
        return EVENTS;
    }

    public Event getByName(String name) {
        return EVENTS.values().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(INVALID_EVENT_NAME));

    }
    @Autowired
    private void initDefaultEvents(List<Event> events) {
        for (Event event : events) {
            long id = ID.getAndIncrement();
            event.setId(id);
            EVENTS.put(id, event);
        }
    }
}
