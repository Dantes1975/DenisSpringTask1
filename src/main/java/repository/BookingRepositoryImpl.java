package repository;

import bean.Booking;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.dao.AbstractRepository;
import repository.dao.BookingRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Repository
public class BookingRepositoryImpl extends AbstractRepository<Booking> implements BookingRepository {
    private static Map<Long, Booking> BOOKINGS = new HashMap<Long, Booking>();
    private static AtomicLong ID = new AtomicLong(1);

    @Autowired
    private void initDefaultBookings(List<Booking> bookings) {
        for (Booking booking : bookings) {
            long id = ID.getAndIncrement();
            booking.setId(id);
            BOOKINGS.put(id, booking);
        }
    }

    @Override
    public Map<Long, Booking> getStorage() {
        return BOOKINGS;
    }
}
