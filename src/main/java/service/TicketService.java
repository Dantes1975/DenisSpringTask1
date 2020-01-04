package service;

import bean.Ticket;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TicketRepositoryImpl;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketService {

    @Autowired
    private TicketRepositoryImpl ticketRepository;

    public Ticket save(Ticket ticket) {
        ticketRepository.save(ticket);
        return ticket;
    }


    public void remove(long id) {
        ticketRepository.remove(id);
    }


    public Ticket getById(long id) {
        return ticketRepository.getById(id);
    }


    public List<Ticket> getAll() {
        return ticketRepository.getAll();
    }


    public List<Ticket> getTicketsByUser(User user) {
        List<Ticket> tickets = ticketRepository.getAll();
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(user)) {
                continue;
            } else {
                tickets.remove(ticket.getId());
            }
        }
        return tickets;
    }
}
