package id.testing.BelajarSpring.service;

import id.testing.BelajarSpring.DTO.User;
import id.testing.BelajarSpring.repos.UserRepository;

public class UserService {
   private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User getUserById(String id) {
        return userRepository.findUserById(id);
    }
}
