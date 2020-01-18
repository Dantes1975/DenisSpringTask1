package aspects;


import bean.Event;
import bean.EventAuditory;
import bean.EventCounter;
import bean.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.CounterAspestDao;

@Aspect
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterAspect {
    @Autowired
    private CounterAspestDao counterAspestDao;

    @AfterReturning(value = "execution(* service.EventService.getByName(..))", returning = "event")
    public void afterGetEventByName(Event event) {
        EventCounter eventCounter = counterAspestDao.getByEvent(event);
        int count = eventCounter.getCountGetByName() + 1;
        eventCounter.setCountGetByName(count);
        counterAspestDao.save(eventCounter);
    }

    @AfterReturning("execution(* service.BookingService.bookTicket(..)) && args(ticket,..)")
    public void afterBookTicket(Ticket ticket) {
        Event event = ticket.getEventAuditory().getEvent();
        EventCounter eventCounter = counterAspestDao.getByEvent(event);
        int count = eventCounter.getCountBooked() + 1;
        eventCounter.setCountBooked(count);
        counterAspestDao.save(eventCounter);
    }

    @AfterReturning("execution(* service.BookingService.getTicketPrice(..)) && args(eventAudit,..)")
    public void afterPriceRequest(EventAuditory eventAudit) {
        Event event = eventAudit.getEvent();
        EventCounter eventCounter = counterAspestDao.getByEvent(event);
        int count = eventCounter.getCountPriceRequested() + 1;
        eventCounter.setCountPriceRequested(count);
        counterAspestDao.save(eventCounter);
    }
}
