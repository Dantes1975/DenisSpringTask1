package config;

import bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.UserRepositoryImpl;
import service.UserService;

import java.time.LocalDate;

@Configuration
public class UserConfig {
    @Bean
    UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepositoryImpl userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public User user1() {
        return new User("Oksana", "Rumyanceva",
                LocalDate.of(1975, 8, 20),"oksana@mail.ru");
    }

    @Bean
    public User user2() {
        return new User("Denis", "Rumyancev",
                LocalDate.of(1975,8,13), "dantes@inbox.ru");
    }

    @Bean
    public User user3() {
        return new User("Viktoriya", "Rumyanceva",
                LocalDate.of(1999, 11, 25), "vika@mail.ru");
    }

}
