package Polytech.Labaratory4.dao;

import Polytech.Labaratory4.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User save(User user);

    User getUserById(String userId);

    boolean deleteUserById(String userId);

    User getUserByUsername(String username);
}
