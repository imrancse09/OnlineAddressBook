package net.therap.service;

import net.therap.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imran
 * Date: 3/18/14
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public User checkLogin(String name, String email);

    public List<User> getUserList();

    public User getUserById(int id);

    public User getUserByName(String userName);

    public void createUser(User user);

}
