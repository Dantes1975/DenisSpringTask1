package config;

import bean.Auditorium;
import bean.Booking;
import bean.EventAuditory;
import bean.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import repository.*;
import service.*;
import strategy.BirthdayStrategy;
import strategy.DiscountStrategy;
import strategy.EveryTenthTicket;


import javax.persistence.EntityManagerFactory;


import static util.StringToArrayUtils.getVipSeats;

@Configuration
@Import({AspectConfig.class, PersistenceJPAConfig.class})
@ComponentScan("java.*")
@PropertySource("classpath:auditorium.properties")
public class EventConfig {

    @Autowired
    Environment env;


    @Bean
    UserService userService(EntityManagerFactory entityManagerFactory) {
        return new UserService(userRepository(entityManagerFactory));
    }

    @Bean
    public UserRepositoryImpl userRepository(EntityManagerFactory entityManagerFactory) {
        return new UserRepositoryImpl(entityManagerFactory);
    }

    @Bean
    AuditoriumService auditoriumService(EntityManagerFactory entityManagerFactory) {
        return new AuditoriumService(auditoriumRepository(entityManagerFactory));
    }


    @Bean
    AuditoriumRepositoryImpl auditoriumRepository(EntityManagerFactory entityManagerFactory) {
        return new AuditoriumRepositoryImpl(entityManagerFactory);
    }

    @Bean
    public BookingService bookingService(EntityManagerFactory entityManagerFactory) {
        return new BookingService(bookingRepository(entityManagerFactory), eventAuditService(entityManagerFactory), discountService());
    }

    @Bean
    public BookingRepositoryImpl bookingRepository(EntityManagerFactory entityManagerFactory) {
        return new BookingRepositoryImpl(entityManagerFactory);
    }

    @Bean
    public Booking booking() {
        return new Booking();
    }

    @Bean
    public EventService eventService(EntityManagerFactory entityManagerFactory) {
        return new EventService(eventRepository(entityManagerFactory));
    }

    @Bean
    public EventRepositoryImpl eventRepository(EntityManagerFactory entityManagerFactory) {
        return new EventRepositoryImpl(entityManagerFactory);
    }


    @Bean
    public EventAuditService eventAuditService(EntityManagerFactory entityManagerFactory) {
        return new EventAuditService(eventAuditRepository(entityManagerFactory));
    }

    @Bean
    public EventAuditRepositoryImpl eventAuditRepository(EntityManagerFactory entityManagerFactory) {
        return new EventAuditRepositoryImpl(entityManagerFactory);
    }


    @Bean
    public TicketService ticketService(EntityManagerFactory entityManagerFactory) {
        return new TicketService(ticketRepository(entityManagerFactory));
    }

    @Bean
    public TicketRepositoryImpl ticketRepository(EntityManagerFactory entityManagerFactory) {
        return new TicketRepositoryImpl(entityManagerFactory);
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
