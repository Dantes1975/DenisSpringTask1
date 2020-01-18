package repository;

import bean.Auditorium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {
    Auditorium getByName(String name);
}
