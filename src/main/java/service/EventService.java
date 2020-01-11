package service;

import bean.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepositoryImpl;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EventService {

   private EventRepositoryImpl eventRepository;

    public Event save(Event event) {
        eventRepository.save(event);
        return event;
    }


    public void remove(long id) {
        eventRepository.remove(id);
    }


    public Event getById(long id) {
        return eventRepository.getById(id);
    }


    public Event getByName(String name) {
        return eventRepository.getByName(name);
    }


    public List<Event> getAll() {
        return eventRepository.getAll();
    }


}
