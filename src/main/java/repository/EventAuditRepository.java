package repository;

import bean.EventAuditory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAuditRepository extends CrudRepository<EventAuditory, Long> {
}
