package service;

import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class UserServiceImpl implements UserService {
    public User save(User user) {
        return null;
    }

    public void remove(long id) {

    }

    public User getById(long id) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }
}
