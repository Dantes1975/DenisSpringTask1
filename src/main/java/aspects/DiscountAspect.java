package aspects;

import bean.Event;
import bean.Ticket;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.aspects.DiscountAspectDao;

@Aspect
@Component
@Data
@AllArgsConstructor
public class DiscountAspect {
    @Autowired
    private DiscountAspectDao discountAspectDao;

    @AfterReturning("execution(* strategy.BirthdayStrategy.getDiscount(..)) && args(user,..)")
    public void afterBirthday(User user) {
        discountAspectDao.setDiscountBirthday(user);
    }

    @AfterReturning("execution(* strategy.EveryTenthTicket.getDiscount(..)) && args(user,..)")
    public void afterTenthTicket(User user) {
        discountAspectDao.setDiscountTenthTicket(user);
    }
}
