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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    @GetMapping("/login")
    public String showLogin() {
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

        userService.saveUser(userDto);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHome(Authentication authentication) {
        System.out.println(authentication);
        return "home";
    }

    @GetMapping("/cars")
    public String showCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);

        List<Country> countries = carService.getAllCountries();
        model.addAttribute("countries", countries);

        List<Type> types = carService.getAllTypes();
        model.addAttribute("types", types);

        return "cars";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable(name = "id") Long id,
                          Model model) {
        User user = userService.getUser(id);
        model.addAttribute("users", user);
        return "user";
    }
}
