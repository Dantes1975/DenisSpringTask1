package repository;

import bean.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.dao.AbstractRepository;
import repository.dao.CrudRepository;
import repository.dao.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Data
@Repository

public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    private static Map<Long, User> USERS = new HashMap<Long, User>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private List<User> users;


    public User getUserByEmail(String email) {
        List<User> users = em.createQuery("SELECT U FROM User U").getResultList();
        em.close();
        User user = null;
        for (User us : users) {
            if (us.getEmail().equals(email)) {
                user = us;
            } else continue;
        }
        return user;

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