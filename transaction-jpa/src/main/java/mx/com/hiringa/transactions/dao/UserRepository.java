package mx.com.hiringa.transactions.dao;

import mx.com.hiringa.transactions.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
