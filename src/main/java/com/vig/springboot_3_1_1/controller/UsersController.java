package com.vig.springboot_3_1_1.controller;

import com.vig.springboot_3_1_1.entity.User;
import com.vig.springboot_3_1_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all-users";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
    model.addAttribute("user", userService.getById(id));
    return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        System.out.println(user.getName());
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }


    @PatchMapping ("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.edit(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
