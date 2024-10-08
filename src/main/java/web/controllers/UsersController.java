package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import web.service.UsersService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users") //это Controller mapping
public class UsersController { // пишем в множественном числе

    private final UsersService usersService; // тип интерфейса, который имплементируется только одним классом

    public UsersController(@Autowired UsersService userService) {
        this.usersService = userService;
    }

    @GetMapping //это Method mapping, значение "/" в скобках можно не указывать
    public String showAllUsers(Model model) { // создаем модель в методе и добавляем Лист в качестве атрибута к этой моделе
        List<User> users = usersService.findAll();
        model.addAttribute("userList", users); // помещаем в модель атрибут(если раскоментируес строку выше-- напишем вместо метода allUsers
        return "users/all";
    }

    @GetMapping("/add")
    public String enterNewUserData(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "users/add-data-page";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("newUser") @Valid User newUserFromView,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/add-data-page";
        }
        usersService.add(newUserFromView);
        return "redirect:/users";
    }
//второй вариант метода
//    @PostMapping("/add")
//    public String addNewUser(@RequestParam("name") String newUserName,
//                             @RequestParam("age") int newUserAge,
//                             @RequestParam("email") String newUserMail,
//                             @RequestParam("sex") String newUserSex) {
//
//        User newUser = new User(newUserName, newUserAge, newUserMail, newUserSex);
//        usersService.add(newUser);
//        return "redirect:/users";
//    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        User editUser = usersService.getById(id);
        model.addAttribute("editUser", editUser);
        return "users/edit-data-page";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") int id,
                           @RequestParam("name") String newUserName,
                           @RequestParam("age") int newUserAge,
                           @RequestParam("email") String newUserMail,
                           @RequestParam("sex") String newUserSex) {
        User user = new User(newUserName, newUserAge, newUserMail, newUserSex);
        user.setUserId(id);
        usersService.edit(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        User user = usersService.getById(id);
        usersService.delete(user);
        return "redirect:/users";
    }
}