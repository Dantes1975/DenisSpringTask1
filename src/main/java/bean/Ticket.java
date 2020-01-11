package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private EventAuditory eventAuditory;
    private int seat;
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    private double price;

}
