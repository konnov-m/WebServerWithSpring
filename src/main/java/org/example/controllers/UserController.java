package org.example.controllers;

import org.example.models.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @GetMapping("/")
    public String userList(Model model){
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/user/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/user/save")
    public RedirectView userSave(@ModelAttribute User user) {
        repository.create(user.getName());
        System.out.println("--------------------------------");
        System.out.println(user.getName());
        return new RedirectView("/", true);
    }

}
