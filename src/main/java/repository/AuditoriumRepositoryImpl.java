package repository;

import bean.Auditorium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import repository.dao.AbstractRepository;
import repository.dao.AuditoriumRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class AuditoriumRepositoryImpl extends AbstractRepository<Auditorium> implements AuditoriumRepository {

    @PersistenceContext
    private EntityManager em;

    private static Map<Long, Auditorium> AUDITORIUMS = new HashMap<Long, Auditorium>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private List<Auditorium> auditoriums;


    @Override
    public Map<Long, Auditorium> getStorage() {
        return AUDITORIUMS;
    }

    public Auditorium getByName(String name) {
        List<Auditorium> auditoriums = em.createQuery(String.format("select a from auditorium a", Auditorium.class)).getResultList();
        em.close();
        Auditorium auditorium = null;
        for (Auditorium aud : auditoriums) {
            if (aud.getName().equals(name)) {
                auditorium = aud;
            } else continue;
        }
        return auditorium;
    }

    @Autowired
    private void initDefaultAuditoriums(List<Auditorium> auditoriums) {
        for (Auditorium auditorium : auditoriums) {
            long id = ID.getAndIncrement();
            auditorium.setId(id);
            AUDITORIUMS.put(id, auditorium);
        }
    }
}
