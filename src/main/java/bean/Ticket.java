package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private long id;
    private EventAuditory eventAuditory;
    private int seat;
    private User user;
    private double price;

}
