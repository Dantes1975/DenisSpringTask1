package aspects;


import bean.Event;
import bean.EventAuditory;
import bean.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.aspects.CounterAspectDao;

@Aspect
@Component
@Data
@AllArgsConstructor
public class CounterAspect {
    @Autowired
    private CounterAspectDao counterAspectDao;


    @AfterReturning(value = "execution(* service.EventService.getByName(..))", returning = "event")
    public void afterGetEventByName(Event event) {
        counterAspectDao.setCounterGetByNameVal(event);
    }

    @AfterReturning("execution(* service.BookingService.bookTicket(..)) && args(ticket,..)")
    public void afterBookTicket(Ticket ticket) {
        Event event = ticket.getEventAuditory().getEvent();
        counterAspectDao.setCounterBookTicket(event);
    }

    @AfterReturning("execution(* service.BookingService.getTicketPrice(..)) && args(eventAudit,..)")
    public void afterPriceRequest(EventAuditory eventAudit) {
        Event event = eventAudit.getEvent();
        counterAspectDao.setCounterPriceRequest(event);
    }
}
