package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Event event;
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    private int seats;
    private LocalDateTime dateTime;
}
