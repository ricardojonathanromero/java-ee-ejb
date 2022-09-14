package mx.com.hiringa.sga.service;

import mx.com.hiringa.sga.domain.User;

import javax.ejb.Remote;
import java.util.List;

@Remote public interface UserServiceRemote {
    List<User> ListUsers();
}
