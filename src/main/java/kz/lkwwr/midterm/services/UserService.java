package kz.lkwwr.midterm.services;

import kz.lkwwr.midterm.dto.UserDto;
import kz.lkwwr.midterm.entities.User;

import java.util.List;

public interface UserService {
    void saveUserDto(UserDto userDto);

    User saveUser(User user);

    User findUserByEmail(String email);

    User getUser(Long id);

    List<UserDto> findAllUsers();

    void deleteUser(User user);
}