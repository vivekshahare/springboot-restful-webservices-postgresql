package com.practice.springboot.service;

import com.practice.springboot.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUSer();

    UserDTO updateUser(UserDTO userDTO, Integer id);

    String deleteUser(Integer id);
}
