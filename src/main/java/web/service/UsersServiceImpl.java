package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true) // можем помечать классы, тогда все публич методы внуори класса по дефолту имеют такую аннотацию
public class UsersServiceImpl implements UsersService {

    private final UserDAO usersDao;

    public UsersServiceImpl(@Autowired UserDAO usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<User> findAllUsers() {
        return usersDao.findAllUsers();
    }

    @Transactional
    @Override
    public void add(User user) {

    }

    @Transactional
    @Override
    public void delete(User user) {

    }

    @Transactional
    @Override
    public void edit(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

}
