package repository.dao;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.lang.reflect.ParameterizedType;
import java.util.List;


//@RequiredArgsConstructor
public abstract class AbstractRepository<T> implements CrudRepository<T> {

    @PersistenceUnit
    private final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    public AbstractRepository(EntityManagerFactory entityManagerFactory) {
        ENTITY_MANAGER_FACTORY = entityManagerFactory;
    }


    private final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    @Override
    public T save(T t) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public T getById(long id) {
        EntityManager em = getEntityManager();
        T t = em.find(clazz, id);
        em.close();
        return t;
    }

    @Override
    public void remove(long id) {
        EntityManager em = getEntityManager();
        T t = em.find(clazz, id);

        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();

        em.close();
    }


    @Override
    public List<T> getAll() {
        EntityManager em = getEntityManager();
        List<T> list = em.createQuery(String.format("select t from %s t", clazz.getName()), clazz)
                .getResultList();
        em.close();
        return list;
    }

    @Override
    public T update(T t) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        t = em.merge(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    protected T getSingleResultByQuery(String query) {
        EntityManager em = getEntityManager();
        T t = em.createQuery(query, clazz)
                .setHint("org.hibernate.cacheable", true)
                .getSingleResult();
        em.close();
        return t;
    }

    protected List<T> getResultListByQuery(String query) {
        EntityManager em = getEntityManager();
        List<T> t = em.createQuery(query, clazz)
                .getResultList();
        em.close();
        return t;
    }

}
