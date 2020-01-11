package aspects;


import bean.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
        int counter = counterAspectDao.getCounter();
        counterAspectDao.deleteCounter();
        counter = counter + 1;
        counterAspectDao.putCounter(counter);
        System.out.println(" Aspect Get by name " + event.getName() + " work " + counter  + " times");
    }

    @AfterReturning("execution(* service.BookingService.bookTicket(..))")
    public void afterBookTicket() {
        int counter = counterAspectDao.getCounter();
        counterAspectDao.deleteCounter();
        counter = counter + 1;
        counterAspectDao.putCounter(counter);
        System.out.println("Aspect Book ticket " + counter);
    }
}
