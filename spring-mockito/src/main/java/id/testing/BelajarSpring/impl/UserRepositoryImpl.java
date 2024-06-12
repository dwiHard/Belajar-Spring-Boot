package id.testing.BelajarSpring.impl;

import java.util.HashMap;
import java.util.Map;

import id.testing.BelajarSpring.DTO.User;
import id.testing.BelajarSpring.repos.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> userData = new HashMap<>();

    @Override
    public void save(User user) {
        userData.put(user.getId(), user);
    }

    @Override
    public User findUserById(String id) {
        return userData.get(id);
    }

}
