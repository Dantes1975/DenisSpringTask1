package service;

import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepositoryImpl;

import java.util.List;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl {
    @Autowired
    private UserRepositoryImpl userRepository;



    public User save(User user) {
        userRepository.save(user);
        return user;
    }


    public void remove(long id) {
        userRepository.remove(id);
    }


    public User getById(long id) {
        return userRepository.getById(id);
    }

        public User getByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }


    public List<User> getAll() {
        return userRepository.getAll();
    }
}
