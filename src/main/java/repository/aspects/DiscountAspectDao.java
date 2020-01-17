package repository.aspects;

import bean.DiscountCounter;
import bean.User;
import org.springframework.stereotype.Component;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Component
public class DiscountAspectDao extends AbstractRepository<DiscountCounter> {
    public DiscountAspectDao(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }

    private final String SET_DISCOUNT_BIRTHDAY = "select d from DiscountCounter d where d.user.id=:userId";
    private final String GET_DISCOUNT_BIRTHDAY = "select d.birthdayStrategy from DiscountCounter d where d.user.id=:userId";
    private final String SET_DISCOUNT_TENTH_TICKET = "select d from DiscountCounter d where d.user.id=:userId";
    private final String GET_DISCOUNT_TENTH_TICKET = "select d.everyTenthTicket from DiscountCounter d where d.user.id=:userId";

    public void setDiscountBirthday(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(SET_DISCOUNT_BIRTHDAY);
        query.setParameter("userId", user.getId());
        DiscountCounter discountCounter = (DiscountCounter) query.getSingleResult();
        int counter = discountCounter.getBirthdayStrategy() + 1;
        discountCounter.setBirthdayStrategy(counter);
        em.merge(discountCounter);
        em.getTransaction().commit();
        em.close();
    }

    public int getDiscountBirthday(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(GET_DISCOUNT_BIRTHDAY);
        query.setParameter("userId", user.getId());
        int result = (int) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public void setDiscountTenthTicket(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(SET_DISCOUNT_TENTH_TICKET);
        query.setParameter("userId", user.getId());
        DiscountCounter discountCounter = (DiscountCounter) query.getSingleResult();
        int counter = discountCounter.getEveryTenthTicket() + 1;
        discountCounter.setEveryTenthTicket(counter);
        em.merge(discountCounter);
        em.getTransaction().commit();
        em.close();
    }

    public int getDiscountTenthTicket(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(GET_DISCOUNT_TENTH_TICKET);
        query.setParameter("userId", user.getId());
        int result = (int) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return result;
    }
}
