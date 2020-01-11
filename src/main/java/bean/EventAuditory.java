package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EventAuditory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Event event;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Auditorium auditorium;
    private LocalDate dateTime;
}
