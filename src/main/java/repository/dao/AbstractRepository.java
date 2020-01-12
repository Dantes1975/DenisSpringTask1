package repository.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> implements CrudRepository<T> {
    private final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public T save(T t) {
        em.persist(t);
        return t;
    }

    @Transactional
    public void remove(long id) {
        T t = em.find(clazz, id);
        em.remove(t);

    }

    @Transactional
    public T getById(long id) {
        return em.find(clazz, id);
    }

    @Transactional
    public T getByName(String name) {
        return null;
    }

    @Transactional
    public List<T> getAll() {
        List<T> list = em.createQuery(String.format("select t from %s t", clazz.getName()), clazz)
                .getResultList();
        return list;
    }

    public abstract Map<Long, T> getStorage();


}
