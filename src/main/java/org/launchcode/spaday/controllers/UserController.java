package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("user")
public class UserController {



    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        User defaultUser = new User("username", "email@server", "sample");
        model.addAttribute( "newUser", defaultUser);
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User newUser , String verify) {
        if (newUser.getPassword().equals(verify)) {
            UserData.addNewUser(newUser);
            model.addAttribute("username", newUser.getUsername());
            return "user/index";
        } else {
            model.addAttribute("error", "The passwords do not match!");
            model.addAttribute("newUser", newUser);
            return "user/add";
        }

    }

}
