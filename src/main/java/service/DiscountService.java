package service;

import bean.EventAuditory;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service

public class DiscountService {

    @Autowired
    private List<DiscountStrategy> discountStrategies;


    public double getDiscount(User user, EventAuditory eventAuditory) {
        List<Double> discounts = new ArrayList<>();
        double discount = 0.0;
        for (DiscountStrategy strategy : discountStrategies) {
            discount = strategy.getDiscount(user, eventAuditory);
            discounts.add(discount);
        }
        discounts.sort((a, b) -> Double.compare(b, a));
        return discounts.get(0);
    }
}
