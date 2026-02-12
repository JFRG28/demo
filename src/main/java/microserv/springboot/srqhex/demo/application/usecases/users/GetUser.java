package microserv.springboot.srqhex.demo.application.usecases.users;

import java.util.List;
import microserv.springboot.srqhex.demo.domain.pojos.User;

public interface GetUser {

    User getUserById(Long id);
    List<User> getAllUsers();

}
