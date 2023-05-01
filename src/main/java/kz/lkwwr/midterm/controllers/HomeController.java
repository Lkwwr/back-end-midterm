//package kz.lkwwr.midterm.controllers;
//
//import kz.lkwwr.midterm.entities.Car;
//import kz.lkwwr.midterm.entities.Country;
//import kz.lkwwr.midterm.services.CarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class HomeController {
//
////    @Autowired
////    private CarService carService;
////
////    @GetMapping(value = "/")
////    public String index(Model model) {
////        List<Car> cars = carService.getAllCars();
////        List<Country> countries = carService.getAllCountries();
////        model.addAttribute("cars", cars);
////        model.addAttribute("countries", countries);
////
////        return "index";
////    }
////
////    @GetMapping(value = "/about")
////    public String about() {
////        return "about";
////    }
////
////    @PostMapping(value = "/additem")
////    public String addItem(@RequestParam(name = "item_name", defaultValue = "Error!") String name,
////                          @RequestParam(name = "item_price", defaultValue = "0") int price) {
////
////
////        return "redirect:/";
////    }
////
////    @GetMapping(value = "/details/{id}")
////    public String details(Model model, @PathVariable(name = "id") Long id){
////        return "details";
////    }
//
//}
