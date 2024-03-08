package com.Blog.app.Payloads;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDTO {

    @Id
    private int id;

    @NotEmpty
    @Size(min = 4, message = " Username must be 4 Characters ! ")
    private String name;

    @Email(message = " Email is Not Valid ")
    private String email;

    @NotEmpty(   )
    @Size(min = 4,max = 10, message = "password min 3 char and max 10 char ! ")
    @Pattern(regexp = "extended")
    private String password;

    @NotEmpty
    private String about;

}
