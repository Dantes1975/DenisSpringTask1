package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auditorium {
    private long id;
    private String name;
    private int numberOfSeats;
    private int[] vipSeats;

    public Auditorium(String name, int numberOfSeats, int[] vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = vipSeats;
    }


}
