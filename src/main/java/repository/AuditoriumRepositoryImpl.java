package repository;

import bean.Auditorium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import repository.dao.AuditoriumRepository;
import repository.dao.CrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static util.ErrorConstant.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class AuditoriumRepositoryImpl implements CrudRepository<Auditorium>, AuditoriumRepository {
    private static Map<Long, Auditorium> AUDITORIUMS = new HashMap<Long, Auditorium>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private List<Auditorium> auditoriums;

    @Override
    public Auditorium save(Auditorium auditorium) {
        long id = ID.getAndIncrement();
        auditorium.setId(id);
        AUDITORIUMS.put(id, auditorium);
        return getById(id);
    }

    @Override
    public void remove(long id) {
        AUDITORIUMS.remove(id);
    }

    @Override
    public Auditorium getById(long id) {
        return AUDITORIUMS.get(id);
    }

    @Override
    public List<Auditorium> getAll() {
        List<Auditorium> list = new ArrayList<>(AUDITORIUMS.values());
        return list;
    }

    @Override
    public Map<Long, Auditorium> getStorage() {
        return AUDITORIUMS;
    }

    public Auditorium getByName(String name) {
        return AUDITORIUMS.values().stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(INVALID_AUDITORIUM_NAME));

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
