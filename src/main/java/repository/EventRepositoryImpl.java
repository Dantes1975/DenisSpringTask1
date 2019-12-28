package repository;

import bean.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class EventRepositoryImpl extends AbstractRepository<Event> implements EventRepository {

}
