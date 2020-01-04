package repository.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> implements CrudRepository<T> {

List<T> list;

    public T save(T t) {
        list.add(t);
        return t;
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
        List<T> list = new ArrayList<>();
        return list;
    }

    public abstract Map<Long, T>getStorage();


}
