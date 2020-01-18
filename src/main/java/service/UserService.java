package service;

import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        userRepository.save(user);
        return user;
    }


    public void remove(long id) {
        userRepository.deleteById(id);
    }


    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }


    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
}
