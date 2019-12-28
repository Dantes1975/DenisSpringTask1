package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public int getTicketsPrice() {
        return 0;
    }
}
