package repository;

import bean.Booking;
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
}
