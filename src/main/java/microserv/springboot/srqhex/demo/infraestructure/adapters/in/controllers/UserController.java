package microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers;

import org.springframework.web.bind.annotation.RestController;

import microserv.springboot.srqhex.demo.application.usecases.users.CreateUser;
import microserv.springboot.srqhex.demo.application.usecases.users.GetUser;
import microserv.springboot.srqhex.demo.domain.pojos.User;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.dto.UserDto;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.mapper.UserMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    private final GetUser getUser;
    private final CreateUser createUser;

    public UserController(GetUser getUser, CreateUser createUser) {
        this.getUser = getUser;
        this.createUser = createUser;
    }

    @GetMapping("/v1/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        // Call the use case to get the user by ID
        User user = getUser.getUserById(id);
        
        // Check if the user is null and return a 404 Not Found response if it is
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Convert the User to UserDto and return it in the response
        UserDto userDto = UserMapper.toUserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/v1/users/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        // Here you would typically call a use case to create the user
        // For demonstration purposes, we will just return the received UserDto
        User user = UserMapper.toAppObject(userDto);
        User createdUser = createUser.createUser(user);
        return ResponseEntity.ok(UserMapper.toUserDto(createdUser));
    }
    

}
