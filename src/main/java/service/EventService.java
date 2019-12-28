package service;

import bean.Event;
import bean.User;

import java.util.List;

public interface EventService {
    Event save(Event event);

    void remove(long id);

    Event getById(long id);

    Event getByName(String name);

    List<Event> getAll();
}
