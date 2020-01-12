package repository;

import bean.EventAuditory;
import repository.dao.AbstractRepository;
import repository.dao.EventAuditRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class EventAuditRepositoryImpl extends AbstractRepository<EventAuditory> implements EventAuditRepository {
    private static Map<Long, EventAuditory> EVENTAUDITORIUMS = new HashMap<Long, EventAuditory>();
    private static AtomicLong ID = new AtomicLong(1);


    @Override
    public Map<Long, EventAuditory> getStorage() {
        return EVENTAUDITORIUMS;
    }


}
