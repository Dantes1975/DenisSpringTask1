package config;


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
}


