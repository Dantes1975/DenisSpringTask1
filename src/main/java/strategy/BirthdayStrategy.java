package strategy;


import bean.EventAuditory;
import bean.User;



public class BirthdayStrategy implements DiscountStrategy {

    @Override
    public int getDiscount(User user, EventAuditory eventAuditory) {
        if (user.getBirthday() == eventAuditory.getDateTime()) {
            return 30;
        } else {
            return 0;
        }
    }
}
