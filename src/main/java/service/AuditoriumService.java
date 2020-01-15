package service;

import bean.Auditorium;
import bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AuditoriumRepositoryImpl;


import java.util.List;

@Data
@Service
@NoArgsConstructor

public class AuditoriumService {

    public AuditoriumService(AuditoriumRepositoryImpl auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    private AuditoriumRepositoryImpl auditoriumRepository;

    public Auditorium save(Auditorium auditorium) {
        auditoriumRepository.save(auditorium);
        return auditorium;
    }
    public Auditorium getByName(String name) {
        return auditoriumRepository.getByName(name);
    }

    public List<Auditorium> getAll() {
        return auditoriumRepository.getAll();
    }
}
