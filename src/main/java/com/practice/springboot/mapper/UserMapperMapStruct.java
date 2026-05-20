package com.practice.springboot.mapper;

import com.practice.springboot.dto.UserDTO;
import com.practice.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperMapStruct {

    UserMapperMapStruct MAPPER = Mappers.getMapper(UserMapperMapStruct.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}