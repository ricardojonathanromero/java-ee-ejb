package mx.com.hiringa.transactions.service;

import mx.com.hiringa.transactions.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local public interface UserService {
    List<User> ListUsers();
}
