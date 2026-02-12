package microserv.springboot.srqhex.demo.application.usecases.users;

import microserv.springboot.srqhex.demo.domain.pojos.User;

public interface CreateUser {

    User createUser(User user);

}
