package com.practice.springboot.service.impl;

import com.practice.springboot.entity.User;
import com.practice.springboot.exception.UserNotFoundException;
import com.practice.springboot.repository.UserRepository;
import com.practice.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow( ()-> new UserNotFoundException("User Not Found"));
    }

    public List<User> getAllUSer() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Integer id) {
        Optional<User> savedUser = userRepository.findById(id);
        if(savedUser.isPresent()){
            User updateUser = savedUser.get();
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setEmail(user.getEmail());
            updateUser.setUpdatedAt(LocalDateTime.now());
            userRepository.save(updateUser);
            return updateUser;
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
