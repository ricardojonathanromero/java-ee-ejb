package mx.com.hiringa.sga.service;

import mx.com.hiringa.sga.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local public interface UserService {
    List<User> ListUsers();
}
