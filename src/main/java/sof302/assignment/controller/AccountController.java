package sof302.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sof302.assignment.entities.User;
import sof302.assignment.consts.Role;
import sof302.assignment.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    private static final String CLIENT_ROLE = "C";
    @Autowired
    IUserService userService;

    @RequestMapping("/logout")
    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/home";
    }

    //Login
    @GetMapping(value = {"/login"})
    public String returnLoginPage(ModelMap model, HttpSession session) {
        if (session.getAttribute("user") != null)
            return "redirect:/home";
        else {
            model.addAttribute("user", new User());
            return "Login";
        }
    }

    @PostMapping("/login")
    public String loginAction(@ModelAttribute User user, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        User userFinded = userService.findByUsernameAndPassword(username, password);
        if (userFinded == null) {
            return "redirect:/login";
        } else {
            session.setAttribute("user", userFinded);
            if (userFinded.getRole().equals("A"))
                return "redirect:/admin";
            else
                return "redirect:/home";
        }
    }
    // End Login

    // Register
    @GetMapping(value = "/register")
    public String returnRegisterPage(ModelMap model, HttpSession session) {
        if (session.getAttribute("user") != null)
            return "redirect:/home";
        else {
            model.addAttribute("user", new User());
            return "Register";
        }
    }
    @PostMapping("/register")
    public String registerAction(@ModelAttribute User user, RedirectAttributes attributes, HttpSession session){
       User checkDuplicateUser = userService.findByUsername(user.getUsername());
       if(!user.getPassword().equals(user.getRepeatpassword())){
           attributes.addFlashAttribute("notification", "Password is not Correct");
           return "redirect:/register";
       }
       if(checkDuplicateUser == null){
           user.setRole(Role.Client);
           userService.saveOrUpdate(user);
           session.setAttribute("user", user);
           attributes.addFlashAttribute("notification", "Register successfully!");
           return "redirect:/information";
       }
        else{
            attributes.addFlashAttribute("notification", "Sorry! Account may have been registered by someone else");
            return "redirect:/register";
       }
    }
    // End Register

    // Update Information
    @GetMapping("/information")
    public String returnInformationPage(HttpSession session, ModelMap model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "Information";
    }

    @PostMapping("/information")
    public String updateInformation(@ModelAttribute User user, HttpSession session){
        userService.saveOrUpdate(user);
        session.setAttribute("user", user);
        return "redirect:/home";
    }
    // End Update Information
}
