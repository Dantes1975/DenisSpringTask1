package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
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
