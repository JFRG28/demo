package microserv.springboot.srqhex.demo.infraestructure.adapters.out.db.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import microserv.springboot.srqhex.demo.application.ports.UserRepository;
import microserv.springboot.srqhex.demo.domain.pojos.User;

@Repository
public class UserInMemoryRepositoryImplement implements UserRepository {

    private static final Map<Long, User> userStore = new HashMap<>();

    public UserInMemoryRepositoryImplement() {
        // Initialize with some mock data
        userStore.put(
            1L, User.builder()
            .id(1L)
            .name("John Doe")
            .email("correo@gmail.com")
            .build());
    }

    @Override
    public User getUserById(Long id) {
        // Mock implementation for demonstration purposes
        return userStore.get(id);
    }

    @Override
    public User createUser(User user) {
        Long id = (long) (userStore.size() + 1); // Simulate auto-increment ID
        user.setId(id);
        userStore.put(id, user);
        return user;
        
    }

    @Override
    public List<User> getAllUsers() {
        // Mock implementation for demonstration purposes
        return userStore.values().stream().toList();
    }

}
