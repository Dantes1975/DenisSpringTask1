package service;

import bean.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class EventServiceImpl implements EventService {
    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Event getById(long id) {
        return null;
    }

    @Override
    public Event getByName(String name) {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return null;
    }
}
