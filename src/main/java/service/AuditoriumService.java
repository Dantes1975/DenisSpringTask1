package service;

import bean.Auditorium;

import java.util.List;

public interface AuditoriumService {
    Auditorium getByName(String name);
    List<Auditorium> getAll();
}
