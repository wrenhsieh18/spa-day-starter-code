package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }
    @PostMapping
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {
//        model.addAttribute("user", user);

        if ( errors.hasErrors() ) {
            return "user/add";
        } else {
            return "user/index";
        }

    }


}
