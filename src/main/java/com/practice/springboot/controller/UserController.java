package com.practice.springboot.controller;

import com.practice.springboot.dto.UserDTO;
import com.practice.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "REST CRUD API for User Management",
        description = "REST CRUD API - Get User, Get All User, Update User, Create User, Delete User"
)
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User and save it into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By Id REST API",
            description = "Get User By Id - get single user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All User REST API",
            description = "Get All User from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> userDTOList = userService.getAllUSer();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update single User by Id from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @PutMapping("{id}/update")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {
        return ResponseEntity.ok(userService.updateUser(userDTO, id));
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete single User by Id from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}