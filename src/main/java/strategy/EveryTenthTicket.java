package strategy;

import bean.Event;
import bean.EventAuditory;
import bean.User;

import java.time.LocalDate;

public class EveryTenthTicket implements DiscountStrategy {

    @Override
    public double getDiscount(User user, EventAuditory eventAuditory) {
        int sizeOfTicketsList = user.getTickets().size();
        if ((sizeOfTicketsList + 1) % 10 == 0) {
            return 0.5;
        } else return 0.0;
    }
}
