package repository;

import bean.Event;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;
import repository.dao.EventRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Data
@Repository
public class EventRepositoryImpl extends AbstractRepository<Event> implements EventRepository {
    @PersistenceContext
    private EntityManager em;

    private static Map<Long, Event> EVENTS = new HashMap<Long, Event>();
    private static AtomicLong ID = new AtomicLong(1);


    @Override
    public Map<Long, Event> getStorage() {
        return EVENTS;
    }

    public Event getByName(String name) {
        List<Event> events = em.createQuery("select e from Event e").getResultList();
        em.close();
        Event event = null;
        for (Event us : events) {
            if (us.getName().equals(name)) {
                event = us;
            } else continue;
        }
        return event;
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
