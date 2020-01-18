package service;

import bean.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepository;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event save(Event event) {
        eventRepository.save(event);
        return event;
    }


    public void remove(long id) {
        eventRepository.deleteById(id);
    }


    public Event getById(long id) {
        return eventRepository.findById(id).orElse(null);
    }


    public Event getByName(String name) {
        return eventRepository.getByName(name);
    }


    public List<Event> getAll() {
        return (List<Event>) eventRepository.findAll();
    }


}
