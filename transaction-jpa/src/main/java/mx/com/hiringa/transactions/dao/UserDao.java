package mx.com.hiringa.transactions.dao;

import mx.com.hiringa.transactions.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
