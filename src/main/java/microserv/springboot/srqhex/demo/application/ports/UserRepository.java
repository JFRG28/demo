package microserv.springboot.srqhex.demo.application.ports;

import java.util.List;
import microserv.springboot.srqhex.demo.domain.pojos.User;

public interface UserRepository {
    
    User getUserById(Long id);

    User createUser(User user);

    List<User> getAllUsers();

}
