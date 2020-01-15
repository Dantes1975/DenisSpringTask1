package repository;

import bean.Booking;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;

import javax.persistence.EntityManagerFactory;


@Repository
public class BookingRepositoryImpl extends AbstractRepository<Booking>{
    public BookingRepositoryImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        super(ENTITY_MANAGER_FACTORY);
    }
}
