package config;


import bean.Auditorium;
import bean.Booking;
import bean.Event;
import bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
    @Bean
    public String hello(){
        return new String("Yello World");
    }

    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public Event event(){
        return new Event();
    }

    @Bean
    public Auditorium auditorium(){
        return new Auditorium();
    }

    @Bean
    public Booking booking(){
        return new Booking();
    }
}


