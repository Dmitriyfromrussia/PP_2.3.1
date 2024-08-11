package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    void editUser(User user);

    User getUserById(int id);
}

