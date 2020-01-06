package repository;

import bean.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.dao.CrudRepository;
import repository.dao.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static util.ErrorConstant.*;

@Data
@Repository
public class UserRepositoryImpl implements CrudRepository<User>, UserRepository {
    private static Map<Long, User> USERS = new HashMap<Long, User>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private List<User> users;

    @Override
    public User save(User user) {
        long id = ID.getAndIncrement();
        user.setId(id);
        USERS.put(id, user);
        return getById(id);
    }

    @Override
    public void remove(long id) {
        USERS.remove(id);
    }

    @Override
    public User getById(long id) {
        return USERS.get(id);
    }


    public User getUserByEmail(String email) {
        List<User> users = new ArrayList<>(USERS.values());
        User user = null;
        for (User us: users) {
            if(us.getEmail().equals(email)){
                user=us;
            } else continue;
        }
        return user;

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>(USERS.values());
        return users;
    }

    @Override
    public Map<Long, User> getStorage() {
        return USERS;
    }

    @Autowired
    private void initDefaultUsers(List<User> users) {
        for (User user : users) {
            long id = ID.getAndIncrement();
            user.setId(id);
            USERS.put(id, user);
        }
    }

}