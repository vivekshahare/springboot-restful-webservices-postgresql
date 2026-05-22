package com.practice.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;

    @Schema(
            description = "User First Name"
    )
    //User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;

    @Schema(
            description = "User Last Name"
    )
    //User last name should not be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    //User email address should not be null or empty
    //User email address should be valid
    @Email(message = "User email address should be valid")
    @NotEmpty(message = "User email address should not be null or empty")
    private String email;
}
