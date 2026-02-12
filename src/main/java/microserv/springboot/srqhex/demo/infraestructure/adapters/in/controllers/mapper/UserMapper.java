package microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.mapper;

import microserv.springboot.srqhex.demo.domain.pojos.User;
import microserv.springboot.srqhex.demo.infraestructure.adapters.in.controllers.dto.UserDto;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toAppObject(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }

}
