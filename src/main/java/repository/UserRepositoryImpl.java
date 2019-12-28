package repository;

import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Data
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

}