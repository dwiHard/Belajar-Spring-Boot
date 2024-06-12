package id.testing.BelajarSpring.repos;

import id.testing.BelajarSpring.DTO.User;

public interface UserRepository {
    User findUserById(String id);
    void save(User user);
}
