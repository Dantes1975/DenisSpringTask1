package config;

import bean.Auditorium;
import bean.Booking;
import bean.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import service.*;
import strategy.BirthdayStrategy;
import strategy.DiscountStrategy;
import strategy.EveryTenthTicket;


import static util.StringToArrayUtils.getVipSeats;

@Configuration
@Import({AspectConfig.class, PersistenceJPAConfig.class})
@ComponentScan("java")
@PropertySource("classpath:auditorium.properties")
public class RootConfig {

    @Autowired
    Environment env;


    @Bean
    UserService userService() {
        return new UserService();
    }

    @Bean
    AuditoriumService auditoriumService() {
        return new AuditoriumService();
    }

    @Bean
    public BookingService bookingService() {
        return new BookingService(eventAuditService(), discountService());
    }

    @Bean
    public Booking booking() {
        return new Booking();
    }

    @Bean
    public EventService eventService() {
        return new EventService();
    }

    @Bean
    public EventAuditService eventAuditService() {
        return new EventAuditService();
    }

    @Bean
    public TicketService ticketService() {
        return new TicketService();
    }

    @Bean
    public Ticket ticket() {
        return new Ticket();
    }

    @Bean
    public DiscountService discountService() {
        return new DiscountService();
    }

    @Bean
    public DiscountStrategy discountStrategy1() {
        return new BirthdayStrategy();
    }

    @Bean
    public DiscountStrategy discountStrategy2() {
        return new EveryTenthTicket();
    }

    @Bean
    public Auditorium auditoriumKosmos() {
        return new Auditorium(env.getProperty("auditorium1.name"),
                Integer.valueOf(env.getProperty("auditorium1.numberOfSeats")),
                getVipSeats(env.getProperty("auditorium1.vipSeats")));
    }

    @Bean
    public Auditorium auditoriumMir() {
        return new Auditorium(env.getProperty("auditorium2.name"),
                Integer.valueOf(env.getProperty("auditorium2.numberOfSeats")),
                getVipSeats(env.getProperty("auditorium2.vipSeats")));
    }

    @Bean
    public Auditorium auditoriumOktyabr() {
        return new Auditorium(env.getProperty("auditorium3.name"),
                Integer.valueOf(env.getProperty("auditorium3.numberOfSeats")),
                getVipSeats(env.getProperty("auditorium3.vipSeats")));

    }
}
