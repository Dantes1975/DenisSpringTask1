import bean.*;
import config.EventConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(EventConfig.class);

    public static void main(String[] args) {

        UserService userService = APPLICATION_CONTEXT.getBean(UserService.class);
        AuditoriumService auditoriumService = APPLICATION_CONTEXT.getBean("auditoriumService", AuditoriumService.class);
        EventService eventService = APPLICATION_CONTEXT.getBean("eventService", EventService.class);
        EventAuditService eventAuditService = APPLICATION_CONTEXT.getBean("eventAuditService", EventAuditService.class);
        //EventAuditory eventAuditory = APPLICATION_CONTEXT.getBean("eventAuditory", EventAuditory.class);
        BookingService bookingService = APPLICATION_CONTEXT.getBean("bookingService", BookingService.class);
        TicketService ticketService = APPLICATION_CONTEXT.getBean("ticketService", TicketService.class);
        DiscountService discountService = APPLICATION_CONTEXT.getBean("discountService", DiscountService.class);


        Scanner in = new Scanner(System.in);

        System.out.println("HELLO");

        System.out.println("Users");
        List<User> users = userService.getAll();
        for (User us : users) {
            System.out.println(us.toString());
        }

        System.out.println("If you register, input 1 or input 2 for registration");
        int registr = in.nextInt();
        User user = new User();
        in.nextLine();
        switch (registr) {
            case 1:
                System.out.println("Input email");
                String yourEmail = in.nextLine();
                user = userService.getByEmail(yourEmail);
                System.out.println("User by email");
                System.out.println(user.toString());
                break;
            case 2:
                System.out.println("Enter your name");
                String name = in.nextLine();
                System.out.println("Enter your surname");
                String surname = in.nextLine();
                System.out.println("Enter year ot your birthday");
                int year = in.nextInt();
                System.out.println("Enter month ot your birthday");
                int month = in.nextInt();
                System.out.println("Enter day ot your birthday");
                int day = in.nextInt();
                in.nextLine();
                System.out.println("Enter your email");
                String email = in.nextLine();

                user.setName(name);
                user.setSurname(surname);
                user.setBirthday(LocalDate.of(year, month, day));
                user.setEmail(email);
                userService.save(user);
                break;
        }

        System.out.println("Events");
        List<Event> events = eventService.getAll();
        for (Event event : events) {
            System.out.println(event.getName());
        }



        Event predator = eventService.getById(1);
        Event terminator = eventService.getById(2);
        Event konan = eventService.getById(3);
        Auditorium kosmos = APPLICATION_CONTEXT.getBean("auditoriumKosmos", Auditorium.class);
        Auditorium mir = APPLICATION_CONTEXT.getBean("auditoriumMir", Auditorium.class);
        Auditorium oktyabr = APPLICATION_CONTEXT.getBean("auditoriumOktyabr", Auditorium.class);

        EventAuditory kosmosPredator = new EventAuditory();
        kosmosPredator.setEvent(predator);
        kosmosPredator.setAuditorium(kosmos);
        kosmosPredator.setDateTime(LocalDate.of(2019, 8, 20));
        eventAuditService.save(kosmosPredator);

        EventAuditory mirTerminator = new EventAuditory();
        EventAuditory oktyabrKonan = new EventAuditory();

        mirTerminator.setEvent(terminator);
        mirTerminator.setAuditorium(mir);
        mirTerminator.setDateTime(LocalDate.of(2019, 8, 20));
        eventAuditService.save(mirTerminator);

        oktyabrKonan.setEvent(konan);
        oktyabrKonan.setAuditorium(oktyabr);
        oktyabrKonan.setDateTime(LocalDate.of(2019, 8, 20));
        eventAuditService.save(oktyabrKonan);

        System.out.println("Auditoriums");
        List<Auditorium> auditoriums = auditoriumService.getAll();
        for (Auditorium aud : auditoriums) {
            System.out.println(aud.getName());
        }


        System.out.println("You can see events from-to dates");
        System.out.println("Enter year ot from-date");
        int yearFrom = in.nextInt();
        System.out.println("Enter month ot from-date");
        int monthFrom = in.nextInt();
        System.out.println("Enter day ot from-date");
        int dayFrom = in.nextInt();
        LocalDate fromDate = LocalDate.of(yearFrom, monthFrom, dayFrom);
        System.out.println("Enter year ot to-date");
        int yearTo = in.nextInt();
        System.out.println("Enter month ot to-date");
        int monthTo = in.nextInt();
        System.out.println("Enter day ot to-date");
        int dayTo = in.nextInt();
        LocalDate toDate = LocalDate.of(yearTo, monthTo, dayTo);

        List<EventAuditory> eventAuditories = eventAuditService.getForDateRange(fromDate, toDate);
        for (EventAuditory event1 : eventAuditories) {
            System.out.println(event1.getEvent().getName() + " " + event1.getDateTime() +
                    " Auditorium " + event1.getAuditorium().getName() + " Base price " +
                    event1.getEvent().getBasePriseOfTicket());
        }

        System.out.println("You can see events to dates");
        System.out.println("Enter year ot to-date");
        int yearTo1 = in.nextInt();
        System.out.println("Enter month ot to-date");
        int monthTo1 = in.nextInt();
        System.out.println("Enter day ot to-date");
        int dayTo1 = in.nextInt();
        LocalDate toDate1 = LocalDate.of(yearTo1, monthTo1, dayTo1);
        List<Event> eventAuditories1 = eventAuditService.getNextEvents(toDate1);
        for (Event event1 : eventAuditories1) {
            System.out.println(event1.getName() + " Base price " + event1.getBasePriseOfTicket());
        }
        in.nextLine();



        System.out.println("Input name of event");
        String eventName = in.nextLine();
        System.out.println("Input date of event");
        System.out.println("Enter year ot to-date");
        int eventEyear = in.nextInt();
        System.out.println("Enter month ot to-date");
        int eventMonth = in.nextInt();
        System.out.println("Enter day ot to-date");
        int eventDay = in.nextInt();
        LocalDate eventDate = LocalDate.of(eventEyear, eventMonth, eventDay);

        Event event1 = eventService.getByName(eventName);
        System.out.println(event1.getName() + " " + event1.getRating());
        EventAuditory eventAuditory1 = eventAuditService.getEventAuditoryByEventNameDate(eventName, eventDate);
        System.out.println("Your choice");
        System.out.println(eventAuditory1.getEvent().getName());
        System.out.println(eventAuditory1.getDateTime());
        System.out.println(eventAuditory1.getAuditorium().getName());
        System.out.println("Base price " + eventAuditory1.getEvent().getBasePriseOfTicket());
        Event event2 = eventService.getByName(eventName);

        System.out.println("Input number of seat");
        int seat = in.nextInt();
        double price = bookingService.getTicketPrice(eventAuditory1, user, seat);
        System.out.println("Base price of ticket");
        System.out.println(eventAuditory1.getEvent().getBasePriseOfTicket());
        System.out.println("Your discount");
        System.out.println(discountService.getDiscount(user, eventAuditory1));
        System.out.println("Price of your ticket = " + price);

        Ticket ticket = (Ticket) APPLICATION_CONTEXT.getBean("ticket");
        ticket.setEventAuditory(eventAuditory1);
        ticket.setUser(user);
        ticket.setSeat(seat);
        ticket.setPrice(price);
        ticketService.save(ticket);
        bookingService.bookTicket(ticket, user);

        System.out.println("YOUR TICKET");
        List<Ticket> tickets = ticketService.getTicketsByUser(user);
        for (Ticket tic : tickets) {
            System.out.println("Name: " + tic.getUser().getName());
            System.out.println("Surname: " + tic.getUser().getSurname());
            System.out.println("Auditorium: " + tic.getEventAuditory().getAuditorium().getName());
            System.out.println("Seat: " + tic.getSeat());
            System.out.println("Date: " + tic.getEventAuditory().getDateTime());
            System.out.println("Total price: " + tic.getPrice());
        }


    }
}
