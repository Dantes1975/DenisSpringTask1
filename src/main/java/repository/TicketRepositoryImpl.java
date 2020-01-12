package repository;

import bean.Event;
import bean.Ticket;
import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.dao.AbstractRepository;
import repository.dao.CrudRepository;
import repository.dao.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TicketRepositoryImpl extends AbstractRepository <Ticket> implements TicketRepository {
    @PersistenceContext
    private EntityManager em;
    private static Map<Long, Ticket> TICKETS = new HashMap<Long, Ticket>();
    private static AtomicLong ID = new AtomicLong(1);




    @Override
    public Map<Long, Ticket> getStorage() {
        return TICKETS;
    }

    @Autowired
    private void initDefaultEvents(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            long id = ID.getAndIncrement();
            ticket.setId(id);
            TICKETS.put(id, ticket);
        }
    }

    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDate date) {
        List<Ticket> tickets = em.createQuery("select t from Ticket t").getResultList();
        for (Ticket ticket : tickets) {
            if (ticket.getEventAuditory().getEvent().equals(event) && ticket.getEventAuditory().getDateTime().equals(date)) {
                continue;
            } else {
                tickets.remove(ticket);
            }
        }
        return tickets;
    }
}
