package kz.lkwwr.midterm.controllers;

import jakarta.validation.Valid;
import kz.lkwwr.midterm.dto.UserDto;
import kz.lkwwr.midterm.entities.Car;
import kz.lkwwr.midterm.entities.Country;
import kz.lkwwr.midterm.entities.Type;
import kz.lkwwr.midterm.entities.User;
import kz.lkwwr.midterm.services.CarService;
import kz.lkwwr.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLogin(Authentication authentication, Model model) {
        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserDto userDto,
                           BindingResult result,
                           Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            return "redirect:/register?error";
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.saveUserDto(userDto);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String showHome(Authentication authentication, Model model) {
        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
        }
        return "home";
    }

    @GetMapping("/about")
    public String showAbout(Authentication authentication, Model model) {
        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
        }
        return "about";
    }

    @GetMapping("/cars")
    public String showCars(Model model, Authentication authentication) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);

        List<Country> countries = carService.getAllCountries();
        model.addAttribute("countries", countries);

        List<Type> types = carService.getAllTypes();
        model.addAttribute("types", types);

        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
        }

        return "cars";
    }

    @GetMapping("/users")
    public String getUsers(Model model, Authentication authentication) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
        }

        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable(name = "id") Long id,
                          Model model, Authentication authentication) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("id", id);
        }

        return "user";
    }

    @PostMapping("/save-user")
    public String saveUser(@RequestParam(name = "id") Long id,
                           @RequestParam(name = "first-name") String firstName,
                           @RequestParam(name = "last-name") String lastName,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password) {
        User user = userService.getUser(id);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        userService.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/home";
    }

    @GetMapping("/car/{id}")
    public String getCar(@PathVariable(name = "id") Long id,
                         Model model, Authentication authentication) {
        Car car = carService.getCar(id);
        model.addAttribute("car", car);

        List<Country> countries = carService.getAllCountries();
        model.addAttribute("countries", countries);

        List<Type> types = carService.getAllTypes();
        model.addAttribute("types", types);

        if (authentication != null) {
            User currentUser = userService.findUserByEmail(authentication.getName());
            model.addAttribute("currentUser", currentUser);
        }

        return "car";
    }
}
