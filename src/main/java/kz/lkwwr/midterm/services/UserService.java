package kz.lkwwr.midterm.services;

import kz.lkwwr.midterm.dto.UserDto;
import kz.lkwwr.midterm.entities.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User getUser(Long id);

    List<UserDto> findAllUsers();

    void deleteUser(User user);
}