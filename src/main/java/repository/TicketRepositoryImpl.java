package repository;

import bean.Event;
import bean.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import repository.dao.CrudRepository;
import repository.dao.TicketRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TicketRepositoryImpl implements CrudRepository<Ticket>, TicketRepository {
    private static Map<Long, Ticket> TICKETS = new HashMap<Long, Ticket>();
    private static AtomicLong ID = new AtomicLong(1);


    @Override
    public Ticket save(Ticket ticket) {
        long id = ID.getAndIncrement();
        ticket.setId(id);
        TICKETS.put(id, ticket);
        return getById(id);
    }

    @Override
    public void remove(long id) {
        TICKETS.remove(id);
    }

    @Override
    public Ticket getById(long id) {
        return TICKETS.get(id);
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = new ArrayList<>(TICKETS.values());
        return tickets;
    }

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
        List<Ticket> tickets = new ArrayList<>(TICKETS.values());
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
