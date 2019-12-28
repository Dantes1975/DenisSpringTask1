package repository;

import bean.Auditorium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class AuditoriumRepositoryImpl extends AbstractRepository<Auditorium> implements AuditoriumRepository {
}
