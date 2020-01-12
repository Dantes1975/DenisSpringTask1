package service;

import bean.Auditorium;
import bean.Event;
import bean.EventAuditory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repository.EventAuditRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class EventAuditService {

    private EventAuditRepositoryImpl eventAuditRepository;

    public EventAuditory save(EventAuditory eventAuditory) {
        eventAuditRepository.save(eventAuditory);
        return eventAuditory;
    }

    public void remove(long id) {
        eventAuditRepository.remove(id);
    }

    public EventAuditory getById(long id) {
        return eventAuditRepository.getById(id);
    }


    public List<EventAuditory> getAll() {
        return eventAuditRepository.getAll();
    }

    public List<Event> getEventForDateRange(LocalDate from, LocalDate to) {
        List<EventAuditory> list = eventAuditRepository.getAll();
        List<Event> events = new ArrayList<>();
        for (EventAuditory event : list) {
            if (event.getDateTime().isAfter(from) && event.getDateTime().isBefore(to)) {
                events.add(event.getEvent());
            }
        }
        return events;
    }

    public List<Event> getNextEvents(LocalDate to) {
        List<EventAuditory> list = eventAuditRepository.getAll();
        List<Event> events = new ArrayList<>();
        for (EventAuditory event : list) {
            if (event.getDateTime().isBefore(to)) {
                events.add(event.getEvent());
            }
        }
        return events;
    }

    public List<EventAuditory> getForDateRange(LocalDate from, LocalDate to) {
        List<EventAuditory> list = eventAuditRepository.getAll();
        for (EventAuditory event : list) {
            if (event.getDateTime().isAfter(from) && event.getDateTime().isBefore(to)) {
                continue;
            } else list.remove(event);
        }
        return list;
    }

    public Auditorium getAuditoryByEventDate(Event event, LocalDate date) {
        List<EventAuditory> list = eventAuditRepository.getAll();
        Auditorium auditorium = null;
        for (EventAuditory eventAudit : list) {
            if (eventAudit.getEvent().equals(event) && eventAudit.getDateTime().equals(date)) {
                auditorium = eventAudit.getAuditorium();
            } else {
                continue;
            }
        }
        return auditorium;
    }

    public EventAuditory getEventAuditoryByEventNameDate(String name, LocalDate date) {
        List<EventAuditory> list = eventAuditRepository.getAll();
        EventAuditory eventAuditory = null;
        for (EventAuditory eventAud : list) {
            if (eventAud.getEvent().getName().equals(name) && eventAud.getDateTime().equals(date)) {
                eventAuditory = eventAud;
            } else continue;
        }
        return eventAuditory;
    }
}
