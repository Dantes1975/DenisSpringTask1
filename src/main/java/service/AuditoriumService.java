package service;

import bean.Auditorium;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuditoriumRepository;


import java.util.List;

@Data
@Service
@NoArgsConstructor
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;


    public Auditorium save(Auditorium auditorium) {
        auditoriumRepository.save(auditorium);
        return auditorium;
    }

    public Auditorium getByName(String name) {
        return auditoriumRepository.getByName(name);
    }

    public List<Auditorium> getAll() {
        return (List<Auditorium>) auditoriumRepository.findAll();
    }
}
