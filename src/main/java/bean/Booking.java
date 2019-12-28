package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private long id;
    private Event event;
    private User user;
    private int seats;
    private LocalDateTime dateTime;
}
