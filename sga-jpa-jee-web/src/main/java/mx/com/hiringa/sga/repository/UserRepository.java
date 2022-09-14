package mx.com.hiringa.sga.repository;

import mx.com.hiringa.sga.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
