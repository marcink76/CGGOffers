package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.User;
import pl.cgg.offers.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/showAll")
    public String showAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "showAllUsers";
    }
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping("addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUserForm";
    }
    @PostMapping("/addUserToBase")
    public String saveUser(Model model,
                           User user,
                           @RequestParam("validPassword") String validPassword){
        if(!validPassword.equals(user.getPassword())){
            model.addAttribute("message", "Hasła nie pasują!");
            return "addUserForm";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        return "redirect:/users/showAll";
    }
}
