package service;

import bean.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void remove(long id);
    User getById(long id);
    User getUserByEmail(String email);
    List <User> getAll();

}
