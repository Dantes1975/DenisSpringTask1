package strategy;


import bean.EventAuditory;
import bean.User;


public class BirthdayStrategy implements DiscountStrategy {

    @Override
    public double getDiscount(User user, EventAuditory eventAuditory) {
        if (user.getBirthday().getMonth() == eventAuditory.getDateTime().getMonth() && user.getBirthday().getDayOfMonth() == eventAuditory.getDateTime().getDayOfMonth()) {
            return 0.3;
        } else {
            return 0.0;
        }
    }
}
