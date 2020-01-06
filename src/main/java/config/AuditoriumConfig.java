package config;

import bean.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import repository.AuditoriumRepositoryImpl;
import service.AuditoriumService;

import static util.StringToArrayUtils.getVipSeats;

@Configuration
@PropertySource("classpath:auditorium.properties")
public class AuditoriumConfig {
    @Bean
    AuditoriumService auditoriumService() {
        return new AuditoriumService(auditoriumRepository());
    }

    @Bean
    AuditoriumRepositoryImpl auditoriumRepository() {
        return new AuditoriumRepositoryImpl();
    }

    @Autowired
    private Environment env;

    @Bean
    public Auditorium auditorium1() {
        return new Auditorium(env.getProperty("auditorium1.name"),
                Integer.valueOf(env.getProperty("auditorium1.numberOfSeats")),
                getVipSeats(env.getProperty("auditorium1.vipSeats")));
    }

    @Bean
    public Auditorium auditorium2() {
        return new Auditorium(env.getProperty("auditorium2.name"),
                Integer.valueOf(env.getProperty("auditorium2.numberOfSeats")),
                getVipSeats(env.getProperty("auditorium2.vipSeats")));
    }

    @Bean
    public Auditorium auditorium3() {
        return new Auditorium(env.getProperty("auditorium3.name"),
                Integer.valueOf(env.getProperty("auditorium3.numberOfSeats")),
                getVipSeats(env.getProperty("auditorium3.vipSeats")));

    }
}
