package service;

import bean.Event;
import bean.Ticket;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TicketRepository;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket save(Ticket ticket) {
        ticketRepository.save(ticket);
        return ticket;
    }


    public void remove(long id) {
        ticketRepository.deleteById(id);
    }


    public Ticket getById(long id) {
        return ticketRepository.findById(id).orElse(null);
    }


    public List<Ticket> getAll() {
        return (List<Ticket>) ticketRepository.findAll();
    }


    public List<Ticket> getTicketsByUser(User user) {
        return ticketRepository.getByUser(user);
    }

    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDate date) {
        List<Ticket> tickets = (List<Ticket>) ticketRepository.findAll();
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
