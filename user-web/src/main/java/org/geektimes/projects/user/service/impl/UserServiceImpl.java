package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.util.Collection;

public class UserServiceImpl implements UserService {

    private UserRepository repository = new DatabaseUserRepository(new DBConnectionManager());

    @Override
    public boolean register(User user) {

        boolean save = repository.save(user);
        Collection<User> all =
                repository.getAll();
        for (User u : all
             ) {
            System.out.println(u);
        }
        return save;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
