package microserv.springboot.srqhex.demo.application.services;

import org.springframework.stereotype.Service;
import microserv.springboot.srqhex.demo.application.ports.UserRepository;
import microserv.springboot.srqhex.demo.application.usecases.users.CreateUser;
import microserv.springboot.srqhex.demo.application.usecases.users.GetUser;
import microserv.springboot.srqhex.demo.domain.pojos.User;


@Service
public class UserService implements GetUser, CreateUser {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        // Mock implementation for demonstration purposes
        return userRepository.getUserById(id);
    }

    @Override
    public User createUser(User user) {
        // Mock implementation for demonstration purposes
        return userRepository.createUser(user); // Simulate creating a user and returning it
    }

}
