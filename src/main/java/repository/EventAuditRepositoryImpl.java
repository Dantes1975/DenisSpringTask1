package repository;

import bean.EventAuditory;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedEntityGraph;

@Repository
@NamedEntityGraph
public class EventAuditRepositoryImpl extends AbstractRepository<EventAuditory>{

    public EventAuditRepositoryImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }


}
