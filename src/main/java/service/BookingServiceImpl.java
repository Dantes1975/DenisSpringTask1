package service;


import bean.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookingRepositoryImpl;
import repository.EventAuditRepositoryImpl;
import repository.EventRepositoryImpl;
import repository.UserRepositoryImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookingServiceImpl {
    @Autowired
    BookingRepositoryImpl bookingRepository;

    @Autowired
    EventAuditService eventAuditService;


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


    public double getTicketPrice(Event event, LocalDate dateTime, User user, int seat) {
        Double price = event.getBasePriseOfTicket();
        Double sumPrice = 0.0;
        Auditorium auditorium = eventAuditService.getAuditoryByEventDate(event, dateTime);
        sumPrice = price * (getRatingPriceCoefficient(event) + getSeatPriceCoefficient(auditorium, seat));
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

    }
}
