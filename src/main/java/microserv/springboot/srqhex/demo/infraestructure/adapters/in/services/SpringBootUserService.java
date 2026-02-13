package microserv.springboot.srqhex.demo.infraestructure.adapters.in.services;

import java.util.List;
import org.springframework.stereotype.Service;
import microserv.springboot.srqhex.demo.application.services.UserService;
import microserv.springboot.srqhex.demo.domain.pojos.User;

@Service
public class SpringBootUserService {

    private final UserService userService;
    
    public SpringBootUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    public User createUser(User user) {
        return userService.createUser(user);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}