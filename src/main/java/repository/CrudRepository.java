package repository;

import bean.User;

import java.util.List;

public interface CrudRepository<T> {
    T save(T t);
    void remove(long id);
    T getById(long id);
    T getByName (String name);
    List<T> getAll();
}
