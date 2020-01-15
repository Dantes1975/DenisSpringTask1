package repository;

import bean.User;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class UserRepositoryImpl extends AbstractRepository<User> {

    public UserRepositoryImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }




    public User getUserByEmail(String email) {
        EntityManager em = getEntityManager();
        List<User> users = em.createQuery("from User ").getResultList();
        em.close();
        User user = null;
        for (User us : users) {
            if (us.getEmail().equals(email)) {
                user = us;
            } else continue;
        }
        return user;

    }



}