package service;


import bean.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookingRepositoryImpl;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookingService {
    @Autowired
    BookingRepositoryImpl bookingRepository;

    @Autowired
    EventAuditService eventAuditService;
    @Autowired
    DiscountService discountService;

    public Booking save(Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }


    public void remove(long id) {
        bookingRepository.remove(id);
    }

    public Booking getById(long id) {
        return bookingRepository.getById(id);
    }

    public List<Booking> getAll() {
        return bookingRepository.getAll();
    }


    public double getTicketPrice(EventAuditory event, User user, int seat) {
        Double price = event.getEvent().getBasePriseOfTicket();
        Double sumPrice = 0.0;
        Auditorium auditorium = event.getAuditorium();
        sumPrice = price * (getRatingPriceCoefficient(event.getEvent()) + getSeatPriceCoefficient(auditorium, seat) -
                discountService.getDiscount(user, event));
        return sumPrice;
    }

    public double getTicketsPrice(EventAuditory event, User user, int[] seats) {
        Double price = event.getEvent().getBasePriseOfTicket();
        Double sumPrice = 0.0;
        Auditorium auditorium = event.getAuditorium();
        for (int i = 0; i < seats.length; i++) {
            sumPrice += price * (getRatingPriceCoefficient(event.getEvent()) + getSeatPriceCoefficient(auditorium, seats[i]));
        }
        return sumPrice;
    }

    private double getSeatPriceCoefficient(Auditorium auditorium, int seat) {
        int[] vipSeatsList = auditorium.getVipSeats();
        for (int i = 0; i < vipSeatsList.length; i++) {
            if (vipSeatsList[i] == seat) {
                return 2.0;
            } else continue;
        }
        return 1.0;
    }


    private double getRatingPriceCoefficient(Event event) {
        if (event.getRating().equals("high")) {
            return 0.2;
        } else if (event.getRating().equals("low")) {
            return -0.2;
        } else {
            return 0.0;
        }
    }

    public void bookTicket(Ticket ticket) {
        List<Ticket> tickets = ticket.getUser().getTickets();
        tickets.add(ticket);
    }
}
