import bean.*;
import config.AuditoriumConfig;
import config.EventConfig;
import config.UserConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.*;

import java.time.LocalDate;
import java.util.List;

public class Runner {
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AuditoriumConfig.class,
            UserConfig.class, EventConfig.class);

    public static void main(String[] args) {

        UserServiceImpl userService = (UserServiceImpl) APPLICATION_CONTEXT.getBean("userService");
        AuditoriumServiceImpl auditoriumService = (AuditoriumServiceImpl) APPLICATION_CONTEXT.getBean("auditoriumService");
        EventServiceImpl eventService = (EventServiceImpl) APPLICATION_CONTEXT.getBean("eventService");
        EventAuditService eventAuditService = (EventAuditService) APPLICATION_CONTEXT.getBean("eventAuditService");
        EventAuditory eventAuditory = (EventAuditory) APPLICATION_CONTEXT.getBean("eventAuditory");
        BookingServiceImpl bookingService = (BookingServiceImpl) APPLICATION_CONTEXT.getBean("bookingService");
        TicketService ticketService = (TicketService) APPLICATION_CONTEXT.getBean("ticketService");

        System.out.println("From list Users");
        List<User> users = userService.getAll();
        for (User us : users) {
            System.out.println(us.toString());
        }

        System.out.println("Events");
        List<Event> users1 = eventService.getAll();
        for (Event us : users1) {
            System.out.println(us.toString());
        }

        List<Auditorium> auditoriums = auditoriumService.getAll();
        for (Auditorium aud : auditoriums) {
            System.out.println(aud.getName());
        }

        User user = userService.getById(1);
        Event event = eventService.getById(3);
        Auditorium auditorium = auditoriumService.getByName("red");
        eventAuditory.setEvent(event);
        eventAuditory.setAuditorium(auditorium);
        eventAuditory.setDateTime(LocalDate.of(2019, 12, 31));
        eventAuditService.save(eventAuditory);

        double price = bookingService.getTicketPrice(event, LocalDate.of(2019, 12, 31), user, 12);
        double price1 = bookingService.getTicketPrice(event, LocalDate.of(2019, 12, 31), user, 9);
        System.out.println(price);
        System.out.println(price1);

        Ticket ticket = (Ticket) APPLICATION_CONTEXT.getBean("ticket");
        ticket.setEventAuditory(eventAuditory);
        ticket.setUser(user);
        ticket.setSeat(12);
        ticket.setPrice(price);
        ticketService.save(ticket);
        List<Ticket> tickets = ticketService.getTicketsByUser(user);
        for (Ticket tic:tickets) {
            System.out.println(tic.toString());
        }
    }
}
