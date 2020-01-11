package repository.aspects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CounterAspectDao {

    private int counter = 0;

    @Autowired
    private List<Integer> counters = new ArrayList<>();

    public int putCounter(int counter) {
        counters.add(counter);
        return counter;
    }

    public int getCounter() {
        return counters.get(0);
    }

    public void deleteCounter() {
        counters.remove(0);
    }
}
