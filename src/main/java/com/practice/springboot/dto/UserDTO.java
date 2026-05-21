package com.practice.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;

    //User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;

    //User last name should not be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    //User email address should not be null or empty
    //User email address should be valid
    @Email(message = "User email address should be valid")
    @NotEmpty(message = "User email address should not be null or empty")
    private String email;
}
