package service;

import bean.Event;
import bean.EventAuditory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventAuditRepositoryImpl;
import repository.EventRepositoryImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EventServiceImpl {
    @Autowired
    EventRepositoryImpl eventRepository;

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
