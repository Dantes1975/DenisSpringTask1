package repository.dao;

import bean.User;

import java.util.List;
import java.util.Map;

public interface CrudRepository<T> {
    T save(T t);
    void remove(long id);
    T getById(long id);
    List<T> getAll();

}
