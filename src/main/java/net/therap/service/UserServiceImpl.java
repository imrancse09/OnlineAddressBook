package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imran
 * Date: 3/18/14
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User checkLogin(String name, String email) {
        return userDao.checkLogin(name, email);
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }
}
