package repository;

import bean.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class BookingRepositoryImpl extends AbstractRepository<Booking> implements BookingRepository {
}
