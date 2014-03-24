package net.therap.dao;

import net.therap.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 3/18/14
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public User checkLogin(String name, String email);

    public List<User> getUserList();

    public User getUserById(int id);

    public User getUserByName(String userName);

    public void createUser(User user);
}
