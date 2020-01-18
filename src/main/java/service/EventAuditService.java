package service;

import bean.Auditorium;
import bean.Event;
import bean.EventAuditory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EventAuditRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventAuditService {

    @Autowired
    EventAuditRepository eventAuditRepository;

    public EventAuditory save(EventAuditory eventAuditory) {
        eventAuditRepository.save(eventAuditory);
        return eventAuditory;
    }

    public void remove(long id) {
        eventAuditRepository.deleteById(id);
    }

    public EventAuditory getById(long id) {
        return eventAuditRepository.findById(id).orElse(null);
    }


    public List<EventAuditory> getAll() {
        return (List<EventAuditory>) eventAuditRepository.findAll();
    }

    public List<Event> getEventForDateRange(LocalDate from, LocalDate to) {
        List<EventAuditory> list = (List<EventAuditory>) eventAuditRepository.findAll();
        List<Event> events = new ArrayList<>();
        for (EventAuditory event : list) {
            if (event.getDateTime().isAfter(from) && event.getDateTime().isBefore(to)) {
                events.add(event.getEvent());
            }
        }
        return events;
    }

    public List<Event> getNextEvents(LocalDate to) {
        List<EventAuditory> list = (List<EventAuditory>) eventAuditRepository.findAll();
        List<Event> events = new ArrayList<>();
        for (EventAuditory event : list) {
            if (event.getDateTime().isBefore(to)) {
                events.add(event.getEvent());
            }
        }
        return events;
    }

    public List<EventAuditory> getForDateRange(LocalDate from, LocalDate to) {
        List<EventAuditory> list = (List<EventAuditory>) eventAuditRepository.findAll();
        for (EventAuditory event : list) {
            if (event.getDateTime().isAfter(from) && event.getDateTime().isBefore(to)) {
                continue;
            } else list.remove(event);
        }
        return list;
    }

    public Auditorium getAuditoryByEventDate(Event event, LocalDate date) {
        List<EventAuditory> list = (List<EventAuditory>) eventAuditRepository.findAll();
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
        List<EventAuditory> list = (List<EventAuditory>) eventAuditRepository.findAll();
        EventAuditory eventAuditory = null;
        for (EventAuditory eventAud : list) {
            if (eventAud.getEvent().getName().equals(name) && eventAud.getDateTime().equals(date)) {
                eventAuditory = eventAud;
            } else continue;
        }
        return eventAuditory;
    }
}
