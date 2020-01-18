package aspects;

import bean.DiscountCounter;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.DiscountAspectDao;


@Aspect
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountAspect {
    @Autowired
    private DiscountAspectDao discountAspectDao;

    @AfterReturning("execution(* strategy.BirthdayStrategy.getDiscount(..)) && args(user,..)")
    public void afterBirthday(User user) {
        DiscountCounter discountCounter = discountAspectDao.getByUser(user);
        int count = discountCounter.getBirthdayStrategy() + 1;
        discountCounter.setBirthdayStrategy(count);
        discountAspectDao.save(discountCounter);
    }

    @AfterReturning("execution(* strategy.EveryTenthTicket.getDiscount(..)) && args(user,..)")
    public void afterTenthTicket(User user) {
        DiscountCounter discountCounter = discountAspectDao.getByUser(user);
        int count = discountCounter.getEveryTenthTicket() + 1;
        discountCounter.setEveryTenthTicket(count);
        discountAspectDao.save(discountCounter);
    }
}
