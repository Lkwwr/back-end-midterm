package kz.lkwwr.midterm.services.impl;

import kz.lkwwr.midterm.dto.UserDto;
import kz.lkwwr.midterm.entities.User;
import kz.lkwwr.midterm.repositories.UserRepository;
import kz.lkwwr.midterm.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUserDto(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User getUser(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = new ArrayList<>();
        for(User user : users) {
            userDto.add(new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()));
        }
        return userDto;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}