package mx.com.hiringa.sga.repository;

import mx.com.hiringa.sga.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext(name = "persistence")
    EntityManager em;

    @Override
    public List<User> findAll() { return em.createNamedQuery("FindAllUsers").getResultList(); }
}
