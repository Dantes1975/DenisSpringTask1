package strategy;

import bean.Event;
import bean.EventAuditory;
import bean.User;

import java.time.LocalDate;

public interface DiscountStrategy {
    double getDiscount(User user, EventAuditory eventAuditory);
}
