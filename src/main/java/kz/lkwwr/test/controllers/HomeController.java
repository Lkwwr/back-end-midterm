package kz.lkwwr.test.controllers;

import kz.lkwwr.test.db.DBManager;
import kz.lkwwr.test.db.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model) {
        ArrayList<Item> items = DBManager.getItems();

        model.addAttribute("items", items);


        return "index";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "item_name", defaultValue = "Error!") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price) {

        Item item = new Item(null, name, price);
        DBManager.addItem(item);

        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){
        Item item = DBManager.getItem(id);
        model.addAttribute("item", item);
        return "details";
    }

}
