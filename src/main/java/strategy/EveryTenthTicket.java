package strategy;

import bean.Event;
import bean.EventAuditory;
import bean.User;

import java.time.LocalDate;

public class EveryTenthTicket implements DiscountStrategy {

    @Override
    public int getDiscount(User user, EventAuditory eventAuditory) {
        return 50;
    }
}
