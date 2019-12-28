package repository;

import bean.Auditorium;
import bean.Event;
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
public class AuditoriumRepositoryImpl extends AbstractRepository<Auditorium> implements AuditoriumRepository {
    private static Map<Long, Auditorium> AUDITORIUMS = new HashMap<Long, Auditorium>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private void initDefaultAuditoriums(List<Auditorium> auditoriums) {
        for (Auditorium auditorium : auditoriums) {
            long id = ID.getAndIncrement();
            auditorium.setId(id);
            AUDITORIUMS.put(id, auditorium);
        }
    }
}
