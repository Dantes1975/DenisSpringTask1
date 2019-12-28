package service;

import bean.Auditorium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    @Override
    public Auditorium getByName(String name) {
        return null;
    }

    @Override
    public List<Auditorium> getAll() {
        return null;
    }
}
