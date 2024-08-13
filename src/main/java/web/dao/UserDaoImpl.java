package web.dao;


import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext // проверить либо @Autowired внедряем то, что раньше называлось SessionFactory
    private EntityManager entityManager;

    @Override
    public List<User> findAllUsers() { // разобраться с null
        //List<User> allUsers = entityManager.createNativeQuery("SELECT * from Users").getResultList();
        //List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        //Query query = entityManager.createQuery("FROM User", User.class); //указываем класс, не название таблицы
        //List<User> allUsers = query.getResultList();
//        TypedQuery<User> query1 = entityManager.createQuery("from User", User.class);
//        return query1.getResultList();
        //System.out.println(allUsers.toString());
        return entityManager.createQuery("from User", User.class).getResultList();
        //return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}