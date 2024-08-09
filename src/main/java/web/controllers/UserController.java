package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.model.User;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import web.service.UsersService;

@Controller
public class UserController {

    private final UsersService usersService; // тип интерфейса, который имплементируется только одним классом

    public UserController(@Autowired UsersService userService) {
        this.usersService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) { // создаем модель в методе и добавляем Лист в качестве атрибута к этой моделе
        List<User> allUsers = usersService.findAllUsers();
        model.addAttribute("userList", allUsers); // помещаем в модель атрибут
        return "allUsers";
    }

//
//    @GetMapping("/add")
//    public String addPage(Model model) {
//        model.addAttribute("user", new User());
//        return "addPage";
//    }
//
//    @PostMapping("/add")
//    public String addUser(@RequestParam("name") String name,
//                          @RequestParam("surname") String surname,
//                          @RequestParam("age") int age,
//                          @RequestParam("email") String email) {
//        User user = new User(name, surname, age, email);
//        userService.add(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/edit")
//    public String editPage(@RequestParam("id") Long id, Model model) {
//        User user = userService.getById(id);
//        model.addAttribute("user", user);
//        return "editPage";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@RequestParam("id") Long id,
//                           @RequestParam("name") String name,
//                           @RequestParam("surname") String surname,
//                           @RequestParam("age") int age,
//                           @RequestParam("email") String email) {
//        User user = new User(name, surname, age, email);
//        user.setId(id);
//        userService.edit(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("id") Long id) {
//        User user = userService.getById(id);
//        userService.delete(user);
//        return "redirect:/users";
//    }
}