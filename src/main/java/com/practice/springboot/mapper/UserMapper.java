package com.practice.springboot.mapper;

import com.practice.springboot.dto.UserDTO;
import com.practice.springboot.entity.User;

public class UserMapper {

    //Convert User JPA Entity into UserDTO
    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    //Convert UserDTO into User JPA Entity
    public static User mapToUser(UserDTO userDTO){
        return new User(userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    }
}
