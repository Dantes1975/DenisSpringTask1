package repository;

import java.util.List;

public abstract class AbstractRepository<T> implements CrudRepository<T> {

    public T save(T t) {
        return null;
    }

    public void remove(long id) {

    }

    public T getById(long id) {
        return null;
    }

    public T getByName(String name) {
        return null;
    }

    public List<T> getAll() {
        return null;
    }
}
