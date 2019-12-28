package repository;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {
    private static Map<Long, User> USERS = new HashMap<Long, User>();
    private static AtomicLong ID = new AtomicLong(1);




    @Autowired
    private void initDefaultUsers(List<User> users) {
        for (User user : users) {
            long id = ID.getAndIncrement();
            USERS.put(id, user);
        }
    }

    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    public void remove(long id) {
        super.remove(id);
    }

    @Override
    public User getById(long id) {
        return super.getById(id);
    }

    @Override
    public User getByName(String name) {
        return super.getByName(name);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }
}
