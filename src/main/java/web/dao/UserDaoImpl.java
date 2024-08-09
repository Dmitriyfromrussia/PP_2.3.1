package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager; // проверить либо @Autowired внедряем то, что раньше называлось SessionFactory

    @Override
    public List<User> findAllUsers() {
//        List<User> allUsers = entityManager.createQuery("FROM User", User.class).getResultList();
        Query query = entityManager.createQuery("FROM User", User.class);
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