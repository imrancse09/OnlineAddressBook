package net.therap.dao;

import net.therap.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl implements UserDao {
    Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Override
    public User checkLogin(String name, String password) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :name IN u.userName AND" +
                " :password IN u.password", User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);
        List<User> userList = query.getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :id IN u.userID",
                User.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No User Found by ID");
        }
        return null;
    }

    @Override
    public User getUserByName(String userName) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :userName IN " +
                "u.userName", User.class);
        query.setParameter("userName", userName);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No User Found By Name");
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        em.merge(user);
    }
}