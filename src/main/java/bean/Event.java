package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENTS")
public class Event implements Serializable {
    @Id
    @SequenceGenerator(name = "EVENTS_ID_SEQ_GEN", sequenceName = "EVENTS_ID_SEQ_GEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENTS_ID_SEQ_GEN")
    private long id;
    private String name;
    private double basePriseOfTicket;
    private String rating;

    public Event(String name, double basePriseOfTicket, String rating) {
        this.name = name;
        this.basePriseOfTicket = basePriseOfTicket;
        this.rating = rating;
    }


}
