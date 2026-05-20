package com.practice.springboot.service.impl;

import com.practice.springboot.dto.UserDTO;
import com.practice.springboot.entity.User;
import com.practice.springboot.exception.UserNotFoundException;
import com.practice.springboot.mapper.UserMapper;
import com.practice.springboot.repository.UserRepository;
import com.practice.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.practice.springboot.mapper.UserMapper.mapToUser;
import static com.practice.springboot.mapper.UserMapper.mapToUserDTO;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO){
         User user = userRepository.save(mapToUser(userDTO));
         return mapToUserDTO(user);
    }

    public UserDTO getUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow( ()-> new UserNotFoundException("User Not Found"));
        return mapToUserDTO(user);
    }

    public List<UserDTO> getAllUSer() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::mapToUserDTO).toList();
    }

    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        Optional<User> savedUser = userRepository.findById(id);
        if(savedUser.isPresent()){
            User updateUser = savedUser.get();
            updateUser.setFirstName(userDTO.getFirstName());
            updateUser.setLastName(userDTO.getLastName());
            updateUser.setEmail(userDTO.getEmail());
            updateUser.setUpdatedAt(LocalDateTime.now());
            userRepository.save(updateUser);
            return mapToUserDTO(updateUser);
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public String deleteUser(Integer id) {
        Optional<User> savedUser = userRepository.findById(id);
        if(savedUser.isPresent()){
            userRepository.deleteById(id);
            return "User Deleted Successfully";
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }


}
