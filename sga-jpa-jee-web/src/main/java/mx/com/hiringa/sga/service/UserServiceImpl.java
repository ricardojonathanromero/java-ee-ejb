package mx.com.hiringa.sga.service;

import mx.com.hiringa.sga.domain.User;
import mx.com.hiringa.sga.repository.UserRepository;

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
