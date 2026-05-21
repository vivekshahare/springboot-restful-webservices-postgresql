package com.practice.springboot.service.impl;

import com.practice.springboot.dto.UserDTO;
import com.practice.springboot.entity.User;
import com.practice.springboot.exception.EmailAlreadyExistsException;
import com.practice.springboot.exception.UserNotFoundException;
import com.practice.springboot.repository.UserRepository;
import com.practice.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.practice.springboot.mapper.UserMapperMapStruct.MAPPER;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> userExists = userRepository.findByEmail(userDTO.getEmail());
        if (userExists.isPresent()) {
            throw new EmailAlreadyExistsException("User Email Already Exists");
        } else {
            User user = userRepository.save(MAPPER.userDTOToUser(userDTO));
            return MAPPER.userToUserDTO(user);
        }
    }

    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return MAPPER.userToUserDTO(user);
    }

    public List<UserDTO> getAllUSer() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(MAPPER::userToUserDTO).toList();
    }

    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setUpdatedAt(LocalDateTime.now());
        User updatedUser = userRepository.save(existingUser);
        return MAPPER.userToUserDTO(updatedUser);
    }

    @Override
    public String deleteUser(Integer id) {
        User savedUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }
}
