package kz.lkwwr.midterm.controllers;

import kz.lkwwr.midterm.entities.Car;
import kz.lkwwr.midterm.entities.Country;
import kz.lkwwr.midterm.entities.Type;
import kz.lkwwr.midterm.entities.User;
import kz.lkwwr.midterm.services.CarService;
import kz.lkwwr.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;

    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }

    @PostMapping("/add-car")
    public String addCar(@RequestParam(name = "name") String name,
                         @RequestParam(name = "model") String model,
                         @RequestParam(name = "volume") double volume,
                         @RequestParam(name = "type") Long type_id,
                         @RequestParam(name = "country") Long country_id,
                         @RequestParam(name = "price") int price) {
        Type type = carService.getType(type_id);
        Country country = carService.getCountry(country_id);
        carService.addCar(new Car(null, name, model, volume, price, type, country));
        return "redirect:/cars";
    }

    @PostMapping("/delete-car")
    public String deleteCar(@RequestParam(name = "id") Long id) {
        Car car = carService.getCar(id);
        carService.deleteCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/car/{id}")
    public String getCar(@PathVariable(name = "id") Long id,
                         Model model){
        Car car = carService.getCar(id);
        model.addAttribute("car", car);
        return "car";
    }
}
