package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventAuditory {
    private long id;
    private Event event;
    private Auditorium auditorium;
    private LocalDate dateTime;
}
