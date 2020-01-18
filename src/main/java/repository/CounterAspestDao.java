package repository;

import bean.Event;
import bean.EventCounter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterAspestDao extends CrudRepository<EventCounter, Long> {
    EventCounter getByEvent(Event event);


    @Query("select e.countGetByName from EventCounter e where e.event=:event")
    int getCounterGetByNameVal(@Param("event") Event event);

    @Query("select e.countBooked from EventCounter e where e.event=:event")
    int getCounterBookTicket(@Param("event") Event event);

    @Query("select e.countPriceRequested from EventCounter e where e.event=:event")
    int getCounterPriceRequest(@Param("event") Event event);
}
