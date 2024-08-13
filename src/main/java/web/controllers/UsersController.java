package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import web.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/users") //это Controller mapping
public class UsersController { // пишем в множественном числе

    private final UsersService usersService; // тип интерфейса, который имплементируется только одним классом

    public UsersController(@Autowired UsersService userService) {
        this.usersService = userService;
    }

    @GetMapping("/hello-page")
    public String presentation() {
        return "hello-page";
    }

    @GetMapping() //это Method mapping, значение "/" в скобках можно не указывать
    public String getAllUsers(Model model) { // создаем модель в методе и добавляем Лист в качестве атрибута к этой моделе
        List<User> users = usersService.findAll();
        model.addAttribute("userList", users); // помещаем в модель атрибут(если раскоментируес строку выше-- напишем вместо метода allUsers
        return "allUsers";
    }

    @GetMapping("/add")
    public String enterNewUserData(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "add-data-page";
    }

//    @GetMapping("/add")
//    public String addNewUser(@RequestParam("name") String newUserName,
//                             @RequestParam("age") int newUserAge,
//                             @RequestParam("email") String newUserMail,
//                             @RequestParam("sex") String newUserSex) {
//
//        User newUser = new User(newUserName, newUserAge, newUserMail, newUserSex);
//        usersService.add(newUser);
//        return "redirect:/users";
//    }

//    @GetMapping("/add")
//    public String addNewUser(Model model) {
//        User newUser = new User();
//        model.addAttribute("newUser", newUser);
//        return "add";
//    }


//@RequestMapping("/save")
//    public String saveNewUser(@ModelAttribute ("newUser") User newUser) {
//    usersService.add(newUser);
//        return "redirect:/users/all";
//    }

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
