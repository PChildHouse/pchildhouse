package pchild.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pchild.domain.User;
import pchild.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: guibin
 * Date: 4/15/14
 * Time: 9:00 PM
 */
@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        }else {
            em.merge(user);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        User mergedUser = em.merge(user);
        em.remove(mergedUser);
    }

    @Override
    public boolean isValid(String username, String password) {
        User user = findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return true;
        }

        return false;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
