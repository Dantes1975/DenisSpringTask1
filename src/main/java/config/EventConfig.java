package config;

import bean.Booking;
import bean.Event;
import bean.EventAuditory;
import bean.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import repository.BookingRepositoryImpl;
import repository.EventAuditRepositoryImpl;
import repository.EventRepositoryImpl;
import repository.TicketRepositoryImpl;
import service.*;
import strategy.BirthdayStrategy;
import strategy.DiscountStrategy;
import strategy.EveryTenthTicket;

@Configuration
@Import({UserConfig.class, AuditoriumConfig.class, AspectConfig.class, PersistenceJPAConfig.class})
public class EventConfig {

    @Bean
    public BookingService bookingService() {
        return new BookingService(bookingRepository(), eventAuditService(), discountService());
    }

    @Bean
    public BookingRepositoryImpl bookingRepository() {
        return new BookingRepositoryImpl();
    }

    @Bean
    public Booking booking() {
        return new Booking();
    }

    @Bean
    public EventService eventService() {
        return new EventService(eventRepository());
    }

    @Bean
    public EventRepositoryImpl eventRepository() {
        return new EventRepositoryImpl();
    }


    @Bean
    public Event event1() {
        return new Event("Predator", 100, "high");
    }

    @Bean
    public Event event2() {
        return new Event("Terminator", 80, "mid");
    }

    @Bean
    public Event event3() {
        return new Event("Konan", 50, "low");
    }


    @Bean
    public EventAuditService eventAuditService() {
        return new EventAuditService(eventAuditRepository());
    }

    @Bean
    public EventAuditRepositoryImpl eventAuditRepository() {
        return new EventAuditRepositoryImpl();
    }

    @Bean
    public EventAuditory eventAuditory() {
        return new EventAuditory();
    }

    @Bean
    public TicketService ticketService(){
        return new TicketService(ticketRepository());
    }

    @Bean
    public TicketRepositoryImpl ticketRepository(){
        return new TicketRepositoryImpl();
    }

    @Bean
    public Ticket ticket(){
        return new Ticket();
    }

    @Bean
    public DiscountService discountService(){
        return new DiscountService();
    }

    @Bean
    public DiscountStrategy discountStrategy1(){
        return new BirthdayStrategy();
    }

    @Bean
    public DiscountStrategy discountStrategy2(){
        return new EveryTenthTicket();
    }

}
