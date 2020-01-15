package repository;

import bean.Event;
import bean.Ticket;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TicketRepositoryImpl extends AbstractRepository <Ticket> {

    public TicketRepositoryImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }

    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDate date) {
        EntityManager em = getEntityManager();
        List<Ticket> tickets = em.createQuery("from Ticket ").getResultList();
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
