package repository;


import bean.EventAuditory;
import bean.Ticket;
import bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List <Ticket> getByUser(User user);
    List<Ticket> getByEventAuditory(EventAuditory eventAuditory);

//    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDate date) {
//        EntityManager em = getEntityManager();
//        List<Ticket> tickets = em.createQuery("from Ticket ").getResultList();
//        for (Ticket ticket : tickets) {
//            if (ticket.getEventAuditory().getEvent().equals(event) && ticket.getEventAuditory().getDateTime().equals(date)) {
//                continue;
//            } else {
//                tickets.remove(ticket);
//            }
//        }
//        return tickets;
//    }
}
