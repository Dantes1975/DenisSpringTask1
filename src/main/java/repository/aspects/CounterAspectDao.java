package repository.aspects;


import bean.Event;
import bean.EventCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Component
public class CounterAspectDao extends AbstractRepository<EventCounter> {

    public CounterAspectDao(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }

    private final String SET_COUNTER_BY_NAME = "select e from EventCounter e where e.event.id=:eventId";
    private final String GET_COUNTER_BY_NAME = "select e.countGetByName from EventCounter e where e.event.id=:eventId";
    private final String SET_COUNTER_BOOK_TICKET = "select e from EventCounter e where e.event.id=:eventId";
    private final String GET_COUNTER_BOOK_TICKET = "select e.countBooked from EventCounter e where e.event.id=:eventId";
    private final String SET_COUNTER_PRICE_REQUEST = "select e from EventCounter e where e.event.id=:eventId";
    private final String GET_COUNTER_PRICE_REQUEST = "select e.countPriceRequested from EventCounter e where e.event.id=:eventId";


    public void setCounterGetByNameVal(Event event) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(SET_COUNTER_BY_NAME);
        query.setParameter("eventId", event.getId());
        EventCounter eventCounter = (EventCounter) query.getSingleResult();
        int counter = eventCounter.getCountGetByName() + 1;
        eventCounter.setCountGetByName(counter);
        em.merge(eventCounter);
        em.getTransaction().commit();
        em.close();
    }

    public int getCounterGetByNameVal(Event event) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(GET_COUNTER_BY_NAME);
        query.setParameter("eventId", event.getId());
        int result = (int) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public void setCounterBookTicket(Event event) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(SET_COUNTER_BOOK_TICKET);
        query.setParameter("eventId", event.getId());
        EventCounter eventCounter = (EventCounter) query.getSingleResult();
        int counter = eventCounter.getCountBooked() + 1;
        eventCounter.setCountBooked(counter);
        em.merge(eventCounter);
        em.getTransaction().commit();
        em.close();
    }

    public int getCounterBookTicket(Event event) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(GET_COUNTER_BOOK_TICKET);
        query.setParameter("eventId", event.getId());
        int result = (int) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public void setCounterPriceRequest(Event event) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(SET_COUNTER_PRICE_REQUEST);
        query.setParameter("eventId", event.getId());
        EventCounter eventCounter = (EventCounter) query.getSingleResult();
        int counter = eventCounter.getCountPriceRequested() + 1;
        eventCounter.setCountPriceRequested(counter);
        em.merge(eventCounter);
        em.getTransaction().commit();
        em.close();
    }

    public int getCounterPriceRequest(Event event) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(GET_COUNTER_PRICE_REQUEST);
        query.setParameter("eventId", event.getId());
        int result = (int) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return result;
    }
}
