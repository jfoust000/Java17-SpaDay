package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm(Model model) {

        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";

    }
    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {

        if (errors.hasErrors()) {

            return "user/add";

        }

        if (user.getVerifyPassword().equals(user.getPassword())) {

            String uName = user.getUserName();
            model.addAttribute("user", uName);
            return "user/index";

        } else {

            user.setPasswordsMatch(false);
            model.addAttribute("passwordsDoNotMatchError", "Passwords don't match");
            model.addAttribute("isPasswordsMatch", user.isPasswordsMatch());
            return "user/add";

       }

    }

}
