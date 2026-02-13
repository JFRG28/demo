package microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import microserv.springboot.srqhex.demo.domain.pojos.User;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.dto.UserDto;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.mapper.UserMapper;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.services.SpringBootUserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

@RestController
public class UserController {

    private final SpringBootUserService springBootUserService;

    public UserController(SpringBootUserService springBootUserService) {
        this.springBootUserService = springBootUserService;
    }

    @GetMapping("v1/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User user = springBootUserService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserDto userDto = UserMapper.toUserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/v1/users/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        // Here you would typically call a use case to create the user
        // For demonstration purposes, we will just return the received UserDto
        User user = UserMapper.toAppObject(userDto);
        User createdUser = springBootUserService.createUser(user);
        return ResponseEntity.ok(UserMapper.toUserDto(createdUser));
    }

    @GetMapping("/v1/users/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // This is a placeholder for the actual implementation to get all users
        // You would typically call a use case to retrieve all users and return them as a list of UserDto
        List<User> users = springBootUserService.getAllUsers();
        List<UserDto> userDtos = users.stream()
                                  .map(UserMapper::toUserDto)
                                  .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
        
    }
}