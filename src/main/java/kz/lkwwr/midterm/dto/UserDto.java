package kz.lkwwr.midterm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "*first name should not be empty")
    private String firstName;
    @NotEmpty(message = "*last name should not be empty")
    private String lastName;
    @NotEmpty(message = "*email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "*password should not be empty")
    private String password;
}