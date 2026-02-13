package microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import microserv.springboot.srqhex.demo.domain.pojos.User;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.dto.UserDto;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.mapper.UserMapper;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.services.SpringBootUserService;

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
}