package repository;

import bean.Auditorium;
import org.springframework.stereotype.Repository;

import repository.dao.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class AuditoriumRepositoryImpl extends AbstractRepository<Auditorium>{

    public AuditoriumRepositoryImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }



    public Auditorium getByName(String name) {
        EntityManager em = getEntityManager();
        List<Auditorium> auditoriums = em.createQuery("from Auditorium ").getResultList();
        em.close();
        Auditorium auditorium = null;
        for (Auditorium aud : auditoriums) {
            if (aud.getName().equals(name)) {
                auditorium = aud;
            } else continue;
        }
        return auditorium;
    }


}
