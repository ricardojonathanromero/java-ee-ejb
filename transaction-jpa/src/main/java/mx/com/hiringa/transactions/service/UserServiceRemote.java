package mx.com.hiringa.transactions.service;

import mx.com.hiringa.transactions.domain.User;

import javax.ejb.Remote;
import java.util.List;

@Remote public interface UserServiceRemote {
    List<User> ListUsers();
}
