package web.service;

import web.models.User;

import java.util.List;

public interface UsersService {

    List<User> findAll();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(int id);
}
