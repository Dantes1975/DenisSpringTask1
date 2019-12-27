package repository;

import bean.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static Map<Long, User> USERS = new HashMap<Long, User>();
    private static AtomicLong ID = new AtomicLong(1);

    public User save(User user) {
        return null;
    }

    public void remove(long id) {

    }

    public User getById(long id) {
        return null;
    }

    public User getByName(String name) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }

    @Autowired
    private void initDefaultUsers(List<User> users){
        for (User user: users) {
            long id = ID.getAndIncrement();

        }
    }
}
