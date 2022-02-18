package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.openmbean.CompositeData;


@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllRegisteredUsers(Model model) {
        model.addAttribute("userData", UserData.getAll());
        return "user/index";
    }

    @GetMapping("{userId}")
    public String displayAllRegisteredUsers(Model model, @PathVariable Integer userId) {
        model.addAttribute("user", UserData.getById(userId));
        return "user/userPage";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute( "username", "username");
        model.addAttribute( "email", "email@domain.server");
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User newUser , String verify) {
        if (newUser.getPassword().equals(verify)) {
            UserData.addNewUser(newUser);
            model.addAttribute("user", newUser);
            return "user/userPage";
        } else {
            model.addAttribute("error", "The passwords do not match!");
            model.addAttribute("username", newUser.getUsername());
            model.addAttribute("email", newUser.getEmail());
            return "user/add";
        }

    }

}
