package repository;

import bean.EventAuditory;
import repository.dao.CrudRepository;
import repository.dao.EventAuditRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class EventAuditRepositoryImpl implements CrudRepository<EventAuditory>, EventAuditRepository {
    private static Map<Long, EventAuditory> EVENTAUDITORIUMS = new HashMap<Long, EventAuditory>();
    private static AtomicLong ID = new AtomicLong(1);


    @Override
    public EventAuditory save(EventAuditory eventAuditory) {
        long id = ID.getAndIncrement();
        eventAuditory.setId(id);
        EVENTAUDITORIUMS.put(id, eventAuditory);
        return getById(id);
    }

    @Override
    public void remove(long id) {
        EVENTAUDITORIUMS.remove(id);
    }

    @Override
    public EventAuditory getById(long id) {
        return EVENTAUDITORIUMS.get(id);
    }

    @Override
    public List<EventAuditory> getAll() {
        List<EventAuditory> list = new ArrayList<>(EVENTAUDITORIUMS.values());
        return list;
    }

    @Override
    public Map<Long, EventAuditory> getStorage() {
        return EVENTAUDITORIUMS;
    }


}
