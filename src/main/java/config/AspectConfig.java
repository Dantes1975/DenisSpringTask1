package config;

import aspects.CounterAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import repository.aspects.CounterAspectDao;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aspects")
public class AspectConfig {

    @Bean
    CounterAspect counterAspect(){
        return new CounterAspect(counterAspectDao());
    }

    @Bean
    public CounterAspectDao counterAspectDao(){
        return new CounterAspectDao();
    }

    @Bean
    public Integer counter(){
        return new Integer(0);
    }
}
