package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext // проверить либо @Autowired внедряем то, что раньше называлось SessionFactory
    private EntityManager entityManager;

    @Override
    public List<User> findAllUsers() { // разобраться с null
//        List<User> allUsers = entityManager.createQuery("FROM User", User.class).getResultList();
        Query query = entityManager.createQuery("FROM User", User.class); //указываем класс, не название таблицы
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }
}