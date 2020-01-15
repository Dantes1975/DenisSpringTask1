package repository;

import bean.Event;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class EventRepositoryImpl extends AbstractRepository<Event> {

    public EventRepositoryImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }

    public Event getByName(String name) {
        EntityManager em = getEntityManager();
        List<Event> events = em.createQuery("from Event").getResultList();
        em.close();
        Event event = null;
        for (Event us : events) {
            if (us.getName().equals(name)) {
                event = us;
            } else continue;
        }
        return event;
    }


}
