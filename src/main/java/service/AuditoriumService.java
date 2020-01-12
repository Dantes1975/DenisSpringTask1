package service;

import bean.Auditorium;
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
@AllArgsConstructor
@Transactional
public class AuditoriumService {

    private AuditoriumRepositoryImpl auditoriumRepository;


    public Auditorium getByName(String name) {
        return auditoriumRepository.getByName(name);
    }

    public List<Auditorium> getAll() {
        return auditoriumRepository.getAll();
    }
}
