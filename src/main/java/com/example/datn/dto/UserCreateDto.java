package com.example.datn.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 *
 * @author vietnq
 */
@Getter
@Setter
public class UserCreateDto {

    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String repeatPassword;

    @Override
    public String toString() {
        return "AccountCreateDto [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
                + ", repeatPassword=" + repeatPassword + "]";
    }

}
