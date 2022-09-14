package mx.com.hiringa.transactions.dao;

import mx.com.hiringa.transactions.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("unchecked")
@Stateless
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext(name = "persistence")
    EntityManager em;

    @Override
    public List<User> findAll() { return em.createNamedQuery("FindAllUsers").getResultList(); }
}
