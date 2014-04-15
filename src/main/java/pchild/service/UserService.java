package pchild.service;

import pchild.domain.User;

import java.util.List;

/**
 * User: guibin
 * Date: 4/15/14
 * Time: 8:58 PM
 */
public interface UserService {
    public List<User> findAll();

    public User findById(Long id);

    public User findByUsername(String username);

    public User save(User user);

    public void delete(User user);

    public boolean isValid(String username, String password);
}
