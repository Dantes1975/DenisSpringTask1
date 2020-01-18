package strategy;

import bean.EventAuditory;
import bean.User;

public class EveryTenthTicket implements DiscountStrategy {

    @Override
    public double getDiscount(User user, EventAuditory eventAuditory) {
        int sizeOfTicketsList = user.getTickets().size();
        if ((sizeOfTicketsList + 1) % 10 == 0) {
            return 0.5;
        } else return 0.0;
    }
}
