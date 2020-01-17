package config;

import aspects.CounterAspect;
import aspects.DiscountAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import repository.aspects.CounterAspectDao;
import repository.aspects.DiscountAspectDao;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aspects")
public class AspectConfig {

    @Bean
    public CounterAspect counterAspect(EntityManagerFactory entityManagerFactory){
        return new CounterAspect(counterAspectDao(entityManagerFactory));
    }

    @Bean
    public CounterAspectDao counterAspectDao(EntityManagerFactory entityManagerFactory){
        return new CounterAspectDao(entityManagerFactory);
    }

    @Bean
    public DiscountAspect discountAspect(EntityManagerFactory entityManagerFactory){
        return new DiscountAspect(discountAspectDao(entityManagerFactory));
    }

    @Bean
    public DiscountAspectDao discountAspectDao(EntityManagerFactory entityManagerFactory){
        return new DiscountAspectDao(entityManagerFactory);
    }
}
