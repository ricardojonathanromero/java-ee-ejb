package mx.com.hiringa.transactions.service;

import mx.com.hiringa.transactions.domain.User;
import mx.com.hiringa.transactions.dao.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserServiceImpl implements UserService, UserServiceRemote {
    @Inject
    UserRepository repository;

    @Override
    public List<User> ListUsers() {
        return repository.findAll();
    }
}
